package dam.project.wearevalencia.fragments;

import org.holoeverywhere.widget.Toast;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;
import com.slidingmenu.lib.SlidingMenu;

import dam.project.wearevalencia.R;

public class Main_Content_Fragment extends SherlockFragment{
	ActionBar actionBar;
	Typeface robotoThin, robotoBoldCondensed;
	SlidingMenu slidingMenu;
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		actionBar = ((SherlockFragmentActivity) getActivity()).getSupportActionBar();
		return inflater.inflate(R.layout.main_content_activity, null);	
	}

	public void onActivityCreated(Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);
		
		//debe ser llamado para crear el men�, de lo contrario no aparecer�n los items en el actionbar
		setHasOptionsMenu(true);
		
		slidingMenu = new SlidingMenu(getActivity());
		//cambiar el actionbar con iconos y fondo personalizado
		changeActionBar();

	}
	
	/*Listener del boton home actionBar */
    public boolean onOptionsItemSelected (MenuItem item){
    	switch(item.getItemId()){
    	case android.R.id.home:
    		slidingMenu.toggle();
    		//toggle(); -> Toggle the SlidingMenu. If it is open, it will be closed, and vice versa.
    		//si no funciona el boton te indica que deslices
    		Toast toast = Toast.makeText(getActivity(), "Desliza el dedo desde el lateral de la pantalla para ver el men�", Toast.LENGTH_SHORT);
    		toast.setGravity(Gravity.CENTER, 0, 0);
    		toast.show();
    		return true;

    	default:
    		return super.onOptionsItemSelected(item);
    	}
    	
    }
	
    ////////	

	private void changeActionBar() {
		
			//Titulo de la app e icono de la izquierda del ABS
			//typeface personalizadas
	        robotoThin = Typeface.createFromAsset(getActivity().getAssets(), "Roboto-Thin.ttf");
	        robotoBoldCondensed = Typeface.createFromAsset(getActivity().getAssets(), "Roboto-BoldCondensed.ttf");
	        
					//actionBar = ((SherlockFragmentActivity) getActivity()).getSupportActionBar();
					//boton de volver atras del boton home, e icono personalizado
					actionBar.setDisplayHomeAsUpEnabled(true);
			       // actionBar.setIcon(R.drawable.action_home);
			        
			        //cambiar el titulo por otro con subtitulo + layout
			        actionBar.setDisplayShowTitleEnabled(false);//ocultar titulo normal
			        //permitir el customizado
			        actionBar.setDisplayShowCustomEnabled(true);
			       
					         
			        //inflar un view con el layout de los titulos
			        View customView = LayoutInflater.from(getActivity()).inflate(R.layout.actionbar_title,null);
			        
			        //identificar las etiquetas y setTypeface otra letra
			        TextView titulo = (TextView)customView.findViewById(R.id.tituloWeAreValencia);
			        titulo.setTypeface(robotoThin);
			        
			        TextView subtitulo =(TextView)customView.findViewById(R.id.titulo2WeAreValencia);
			        subtitulo.setTypeface(robotoBoldCondensed);

			        //set inflate view to actionBarSherlock
			        actionBar.setCustomView(customView);
		
					
		}
		//////////
	


		
	
}
