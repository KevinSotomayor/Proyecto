package dam.project.wearevalencia.maps;

import org.holoeverywhere.widget.Toast;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.SubMenu;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import dam.project.wearevalencia.LugaresDeInteres_Ficha_Item;
import dam.project.wearevalencia.R;
import dam.project.wearevalencia.gallery.Gallery_Item;
import dam.project.wearevalencia.objects.LugaresDeInteres_Item;

public class Map_Item extends SherlockFragmentActivity  implements LocationListener{
	private Typeface robotoThin, robotoBoldCondensed, robotoCondensed;
	private ActionBar actionBar;
	
	//constantes para identificar que opcion de menu se selecciona.
	private final int MAPA_NORMAL = 1;
	private final int MAPA_HYBRIDO = 2;
	private final int MAPA_SATELITE = 3;
	
	private final int MAPA_TERRANEO = 4;
	
	//constantes para el minimo de tiempo en actualizar la posicion y la distancia en radio de la posicion actual
	private final int MIN_TIME = 2000;
	private final int MIN_DISTANCE = 50;	
	private final String BUNDLE_OBJECT_ARRAYLIST = "objetoTotal";
	private LugaresDeInteres_Item objeto; 


	//escuchar los cambios de posicion del usuario
	private LocationManager locationManager;
	GoogleMap mapa;
	Location location;
	String provider;
	boolean flag = false;
	
	private LatLng myPosition;
	private LatLng myDestine;
	String tituloMarker;
	String direccion;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map_and_gallery);
		
		Bundle bundle = getIntent().getExtras();
		if (bundle != null) {
			objeto = bundle.getParcelable(BUNDLE_OBJECT_ARRAYLIST);
			myDestine = objeto.getLatLng();
			tituloMarker = objeto.getTitle();
			direccion = objeto.getAddres();
		}
		
		
		//action bar + personalizaciones
		actionBar = getSupportActionBar();
        changeActionBar();
        
        //Obteniendo el estado de google play services, ya que gracias a ello se muestra el mapa
        int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getBaseContext());
    	
        // Mostrar mapa y dem�s si est� disponible
        if(status!=ConnectionResult.SUCCESS){ // Google Play Services no esta disponible
            int requestCode = 10;
            Dialog dialog = GooglePlayServicesUtil.getErrorDialog(status, this, requestCode);
            //http://developer.android.com/intl/es/google/play-services/setup.html
            dialog.show();
        }else{
  
	        mapa = ((SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
			goToTorresDeSerranos();
			
			 ImageButton myPosition = (ImageButton)findViewById(R.id.myLocationButton);
		        myPosition.setOnClickListener(new OnClickListener() {
					
		        	@Override
					public void onClick(View v) {

						new Handler().post(new Runnable() {
							
							@Override
							public void run() {
				    			if(!flag == true){
									Toast.makeText(getApplicationContext(), "Obteniendo tu ubicaci�n, espera...", Toast.LENGTH_LONG).show();
				    				flag = true;
				    			}else{
										Toast.makeText(Map_Item.this, "Ya te he ubicado...", Toast.LENGTH_LONG).show();
										
									}
				    				mapa.setMyLocationEnabled(true);
					    			// obteniendo el objeto LocationManager desde el System Service -> LOCATION_SERVICE
					    	     	locationManager = (LocationManager)getSystemService(LOCATION_SERVICE);
					    			Criteria criteria = new Criteria(); //establecemos precision
					    			criteria.setAccuracy(Criteria.ACCURACY_FINE); //establecemos que se escuche al mejor proveedor de se�al, ya sea el wifi, gps o red movil
					    			provider = locationManager.getBestProvider(criteria, true); //devuelve en un string el provider con los mejores criterios 
							        
									if(locationManager != null){
										boolean gpsEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
										boolean networkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
										
										if(!gpsEnabled){
											Toast toast = Toast.makeText(getApplicationContext(), "GPS Deshabilitado, act�valo para mejor precisi�n", Toast.LENGTH_LONG);
											toast.setGravity(Gravity.CENTER,0,0);
											toast.show();
										}
										if(!networkEnabled){
											Toast toast = Toast.makeText(getApplicationContext(), "No hay conexi�n de datos, act�vela para mostrar el mapa", Toast.LENGTH_LONG);
											toast.setGravity(Gravity.CENTER,0,0);
											toast.show();
										}
									}
												
									location = locationManager.getLastKnownLocation(provider);
									//Returns a Location indicating the data from the last known location fix obtained from the given provider. 
						
									if(location!=null)
										onLocationChanged(location);
									
							}
						});
	        	}
			});
		        if(locationManager != null)
		        	locationManager.requestLocationUpdates(provider, MIN_TIME, MIN_DISTANCE, this); //obtener actualizaciones de posicionamiento

        }
        

        ImageButton galeria = (ImageButton)findViewById(R.id.torresdeserranos_galleryButton);
        galeria.setOnClickListener(new OnClickListener() {
			
        	@Override
			public void onClick(View v) {
        		goToIntent();
			}
		});
        

        ImageButton visitedSite = (ImageButton)findViewById(R.id.visitedSiteButton);
        visitedSite.setOnClickListener(new OnClickListener() {
			
        	@Override
			public void onClick(View v) {
        		
        		Toast.makeText(getApplicationContext(), "He visitado ya las Torres de Serranos", Toast.LENGTH_LONG).show();
    	           
    			}
		
		});
        
        //trazar ruta entre mi posicion y mi destino
        ImageButton makeRoute = (ImageButton)findViewById(R.id.makeRouteButton);
        makeRoute.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "Estableciendo ruta...", Toast.LENGTH_LONG).show();
				new Handler().post(new Runnable() {
					
					@Override
					public void run() {
						
					}
				});
			}
			
		});
        
        //cuando se pulse el boton, se posicionara nuevamente al usuario con la vista de las torres de serranos.
        ImageButton goLocation = (ImageButton)findViewById(R.id.goLocationMapButton);
        goLocation.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				goToTorresDeSerranos();
				
			}
		});
	}
	
	//Menu para ver el mapa con diferentes vistas
	public boolean onCreateOptionsMenu(Menu menu){			
		super.onCreateOptionsMenu(menu);
		SubMenu submenu = menu.addSubMenu(getString(R.string.optionsMaps));
		submenu.add(0, MAPA_NORMAL, 0, getString(R.string.mapaNormal));
		submenu.add(0, MAPA_HYBRIDO, 1, getString(R.string.mapaHibryd));
		submenu.add(0, MAPA_SATELITE, 2,getString(R.string.mapaSatelite));
		submenu.add(0, MAPA_TERRANEO, 3, getString(R.string.mapaTerraneo));
		submenu.getItem().setIcon(R.drawable.abs__ic_menu_moreoverflow_normal_holo_dark)
		.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		
		return true;
		
		}
	
	public boolean onOptionsItemSelected (MenuItem item){
    	
		switch(item.getItemId()){
    	
    	case android.R.id.home:
    		Map_Item.this.finish();
			//sobreescribir la animacion para finalizar esta activity
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

    		return true;
    	
    	case 0:
    		break;
    		
    	case MAPA_NORMAL:
    		mapa.setMapType(GoogleMap.MAP_TYPE_NORMAL);
    		break;
    		
    	case MAPA_HYBRIDO:
    		mapa.setMapType(GoogleMap.MAP_TYPE_HYBRID);
    		break;
    		
    	case MAPA_SATELITE:
    		mapa.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
    		break;
    		
    	case MAPA_TERRANEO:
    		mapa.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
    		break;	

    	}
    	
		Log.e("Variable item", "" + item.getItemId());

		return super.onOptionsItemSelected(item);

    }
	
	
	private void goToTorresDeSerranos(){
		//establecer la posicion y marker de las torres de serranos:		
		//dirige la posicion del mapa hacia esa latitud y esa longitud
		CameraPosition cameraPosition = new CameraPosition.Builder()
		.target(myDestine)
		.zoom(17)
		//.bearing(285) //angulo de orientacion
		//.tilt(75) //angulo de vista 
		.build();

		
		CameraUpdate cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition);
		mapa.animateCamera(cameraUpdate); //animacion para llegar a la lat y long indiciados que se le pasa al objeto cameraupdate
		mapa.addMarker(new MarkerOptions() //marker personalizado
		.position(myDestine)
		.title(tituloMarker)
		.snippet(direccion.toUpperCase())
		.icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_map_red)))
		.showInfoWindow();
	
	
	}

	private void goToIntent(){
		Intent galeria = new Intent(Map_Item.this, Gallery_Item.class);
		Bundle bundle = new Bundle();
		bundle.putParcelable(BUNDLE_OBJECT_ARRAYLIST, objeto);
		galeria.putExtras(bundle);
		startActivity(galeria);
		//sobreescribir la animacion para dar entrada a la nueva pantalla
		overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
	}
	
	
	private void changeActionBar() {
		//typeface personalizadas
        robotoThin = Typeface.createFromAsset(getAssets(), "Roboto-Thin.ttf");
        robotoBoldCondensed = Typeface.createFromAsset(getAssets(), "Roboto-BoldCondensed.ttf");
        robotoCondensed = Typeface.createFromAsset(getAssets(), "Roboto-Condensed.ttf");

				//boton de volver atras del boton home, e icono personalizado
				actionBar.setDisplayHomeAsUpEnabled(false);
        		actionBar.setHomeButtonEnabled(true);
		        actionBar.setIcon(R.drawable.ic_navigation_back);

		        //cambiar el titulo por otro con subtitulo + layout
		        actionBar.setDisplayShowTitleEnabled(false);//ocultar titulo normal
		        //permitir el customizado
		        actionBar.setDisplayShowCustomEnabled(true);


		        //inflar un view con el layout de los titulos
		        View customView = LayoutInflater.from(this).inflate(R.layout.actionbar_title,null);

		        //identificar las etiquetas y setTypeface otra letra
		        TextView titulo = (TextView)customView.findViewById(R.id.tituloWeAreValencia);
		        titulo.setTypeface(robotoBoldCondensed);
		        titulo.setText(tituloMarker.toUpperCase());
		        
		        /// center xml in actionbar
		        ActionBar.LayoutParams lp = new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT);
		        lp.gravity = Gravity.CENTER;
		        customView.setLayoutParams(lp);
		        /* http://stackoverflow.com/questions/11327210/setting-a-custom-text-in-the-center-actionbarsherlock */

		        //set inflate view to actionBarSherlock
		        actionBar.setCustomView(customView);

	}
	
/*	public void onPause(){
		super.onPause();
		if(locationManager != null){
			locationManager.removeUpdates((LocationListener)this);
		}
	}
	
	public void onResume(){
		super.onResume();
		initMap();
		if(locationManager != null){
			mapa.setMyLocationEnabled(true);
		}
	}*/

	@Override
	public void onLocationChanged(Location location) {
		if(location != null){
			//obteniendo la latitud de mi posicion actual
			double latitude = location.getLatitude();
			
			//obteniendo la longitud de mi posicion actual
			double longitude = location.getLongitude();
			
			//direccion de mi posicion actual
			LatLng myCurrentPosition = new LatLng(latitude, longitude);
			myPosition = myCurrentPosition;
			//mover la posicion del mapa hacia donde estoy ubicado en ese momento
			CameraPosition myCameraPosition = new CameraPosition.Builder()
			.target(myCurrentPosition)
			.zoom(18)
			.build();
			CameraUpdate cameraUpdate = CameraUpdateFactory.newCameraPosition(myCameraPosition);
			mapa.animateCamera(cameraUpdate);
			mapa.addMarker(new MarkerOptions() //marker personalizado
			.position(myPosition)
			.title(getString(R.string.estoyAqui))
			.snippet(getString(R.string.obteniendoDireccion))
			.icon(BitmapDescriptorFactory.fromResource(R.drawable.my_position_marker)))
			.showInfoWindow();

		}
		
	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}

}