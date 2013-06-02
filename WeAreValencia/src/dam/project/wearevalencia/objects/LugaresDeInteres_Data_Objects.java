package dam.project.wearevalencia.objects;

/*
 * 
 * Clase para formar objetos y devolver arraylist con los objetos cargados.
 * 
 * Estructura de datos de cada objeto:
 * 
 * -id
 * -titulo
 * -contenido
 * -categoria
 * -latitud y longitud en el mapa
 * -"miniatura de la lista de lugares de interes que es la misma que la de la ficha del lugar de interes" -> este antes existia
 * 		Ahora la miniatura que se comparte es thumbailMax que sirve tanto como para la lista de lugares como para la ficha
 * -direccion
 * -precio
 * -horario
 * -telefono
 * -miniatura de fondo item ficha
 * -array de las fotos que se presentan en la galer�a
 * 
 * 
 * 
 */


import java.util.ArrayList;
import android.content.Context;
import com.google.android.gms.maps.model.LatLng;
import dam.project.wearevalencia.R;

public class LugaresDeInteres_Data_Objects {
	
	private static ArrayList<LugaresDeInteres_Item> arrayList;
	private static LatLng latlng = null;
	private static int[] arrayGallery;
	
	/*constantes identificadoras de cada lugar*/
	private static final  int LONJA_SEDA = 1;
	private static final  int TORRES_DE_SERRANOS = 2;
	private static final int TORRES_DE_QUART = 3;
	private static final int MERCADO_CENTRAL = 4;
	private static final int MERCADO_COLON = 5;
	private static final int CAC = 6;
	private static final int PLAZA_AYUNTAMIENTO = 7;
	private static final int ESTACION_NORTE =8;
	private static final int PLAZA_TOROS = 9;
	private static final int PLAZA_VIRGEN = 10;
	private static final int MICALET = 11;
	private static final int HEMISFERIC = 12;
	private static final int MUSEO_DE_LAS_CIENCIAS = 13;
	private static final int OCEANOGRAFIC = 14;
	private static final int PALAU_DE_LES_ARTS = 15;
	private static final int UMBRACLE = 16;
	private static final int AGORA = 17;
	
	//devolver lista de lugares de interes - Monumentos
	public static ArrayList<LugaresDeInteres_Item> obtainMonuments(Context contexto){
			arrayList = new ArrayList<LugaresDeInteres_Item>();
			//sobreescribir estas variables que contendr�n otra informaci�n como la latlong y las imagenes
			//que leer� de la sd.
			latlng = new LatLng(39.47434857729124, -0.3785929481113093);
			arrayGallery = new int[]{R.drawable.main_bg_1, R.drawable.main_bg_2, R.drawable.main_bg_3, R.drawable.main_bg_4, R.drawable.main_bg_5};
			LugaresDeInteres_Item lonjaDeLaSeda =  new LugaresDeInteres_Item(
					LONJA_SEDA,
					contexto.getString(R.string.lonjaDeLaSeda), 
					contexto.getString(R.string.LonjaDeLaSedaContent), 
					contexto.getString(R.string.Monumentos),
					latlng, 
					contexto.getString(R.string.lonjaDeLaSedaAddress),
					contexto.getString(R.string.lonjaDeLaSedaPrice),
					contexto.getString(R.string.lonjaDeLaSedaHorary),
					contexto.getString(R.string.lonjaDeLaSedaTelephone),
					R.drawable.lugaresdeinteres_ficha_lonjadelaseda, 
					arrayGallery
					);
			
			latlng = new LatLng(39.47913178119177,-0.37600058732025765);
			LugaresDeInteres_Item torresDeSerranos =  new LugaresDeInteres_Item(
					TORRES_DE_SERRANOS,
					contexto.getString(R.string.torresDeSerranos), 
					contexto.getString(R.string.torresDeSerranosContent), 
					contexto.getString(R.string.Monumentos),
					latlng, 
					contexto.getString(R.string.torresDeSerranosAddress),
					contexto.getString(R.string.torresDeSerranosPrice),
					contexto.getString(R.string.torresDeSerranosHorary),
					contexto.getString(R.string.torresDeSerranosTelephone),
					R.drawable.lugaresdeinteres_ficha_torresdeserranos, 
					arrayGallery
					);
			
			latlng = new LatLng(39.47574166307943,-0.3841759499999853); 
			LugaresDeInteres_Item torresDeQuart =  new LugaresDeInteres_Item(
					TORRES_DE_QUART,
					contexto.getString(R.string.torresDeQuart), 
					contexto.getString(R.string.torresDeQuartContent), 
					contexto.getString(R.string.Monumentos),
					latlng, 
					contexto.getString(R.string.torresDeQuartAddress),
					contexto.getString(R.string.torresDeQuartPrice),
					contexto.getString(R.string.torresDeQuartHorary),
					contexto.getString(R.string.torresDeQuartTelephone),
					R.drawable.lugaresdeinteres_ficha_torresquart, 
					arrayGallery
					);
			
			latlng = new LatLng(39.473612081180725,-0.3793405272460859); 
			LugaresDeInteres_Item mercadoCentral =  new LugaresDeInteres_Item(
					MERCADO_CENTRAL,
					contexto.getString(R.string.mercadoCentral), 
					contexto.getString(R.string.mercadoCentralContent), 
					contexto.getString(R.string.Monumentos),
					latlng, 
					contexto.getString(R.string.mercadoCentralAddress),
					contexto.getString(R.string.mercadoCentralPrice),
					contexto.getString(R.string.mercadoCentralHorary),
					contexto.getString(R.string.mercadoCentralTelephone),
					R.drawable.lugaresdeinteres_ficha_mercadocentral, 
					arrayGallery
					);
			
			latlng = new LatLng(39.46880596688192,-0.3688555079345468);
			LugaresDeInteres_Item mercadoColon =  new LugaresDeInteres_Item(
					MERCADO_COLON,
					contexto.getString(R.string.mercadoColon), 
					contexto.getString(R.string.mercadoColonContent), 
					contexto.getString(R.string.Monumentos),
					latlng, 
					contexto.getString(R.string.mercadoColonAddress),
					contexto.getString(R.string.mercadoColonPrice),
					contexto.getString(R.string.mercadoColonHorary),
					contexto.getString(R.string.mercadoColonTelephone),
					R.drawable.lugaresdeinteres_ficha_mercadocolon, 
					arrayGallery
					);
			
			latlng = new LatLng(39.45697498085445,-0.3526350330353045); 
			LugaresDeInteres_Item ciudadartesyciencias =  new LugaresDeInteres_Item(
					CAC,
					contexto.getString(R.string.cac), 
					contexto.getString(R.string.cacContent), 
					contexto.getString(R.string.Monumentos),
					latlng, 
					contexto.getString(R.string.cacAddress),
					contexto.getString(R.string.cacPrice),
					contexto.getString(R.string.cacHorary),
					contexto.getString(R.string.cacTelephone),
					R.drawable.lugaresdeinteres_ficha_cac, 
					arrayGallery
					);
			
			latlng = new LatLng(39.46977456919956,-0.37673604736028654); 
			LugaresDeInteres_Item plazaAyuntamiento =  new LugaresDeInteres_Item(
					PLAZA_AYUNTAMIENTO,
					contexto.getString(R.string.plazaAyuntamiento), 
					contexto.getString(R.string.plazaAyuntamientoContent), 
					contexto.getString(R.string.Monumentos),
					latlng, 
					contexto.getString(R.string.plazaAyuntamientoAddress),
					contexto.getString(R.string.plazaAyuntamientoPrice),
					contexto.getString(R.string.plazaAyuntamientoHorary),
					contexto.getString(R.string.plazaAyuntamientoTelephone),
					R.drawable.lugaresdeinteres_ficha_plazaayuntamiento, 
					arrayGallery
					);
			
			latlng = new LatLng(39.467364213075506,-0.3770545999999513); 
			LugaresDeInteres_Item estacionNorte =  new LugaresDeInteres_Item(
					ESTACION_NORTE,
					contexto.getString(R.string.estacionDelNorte), 
					contexto.getString(R.string.estacionDelNorteContent), 
					contexto.getString(R.string.Monumentos),
					latlng, 
					contexto.getString(R.string.estacionDelNorteAddress),
					contexto.getString(R.string.estacionDelNortePrice),
					contexto.getString(R.string.estacionDelNorteHorary),
					contexto.getString(R.string.estacionDelNorteTelephone),
					R.drawable.lugaresdeinteres_ficha_estacionnorte, 
					arrayGallery
					);
			
			latlng = new LatLng(39.46723169263762,-0.3757349531646259); 
			LugaresDeInteres_Item plazaToros =  new LugaresDeInteres_Item(
					PLAZA_TOROS,
					contexto.getString(R.string.plazaDeToros), 
					contexto.getString(R.string.plazaDeTorosContent), 
					contexto.getString(R.string.Monumentos),
					latlng, 
					contexto.getString(R.string.plazaDeTorosAddress),
					contexto.getString(R.string.plazaDeTorosPrice),
					contexto.getString(R.string.plazaDeTorosHorary),
					contexto.getString(R.string.plazaDeTorosTelephone),
					R.drawable.lugaresdeinteres_ficha_plazatoros, 
					arrayGallery
					);
			
			latlng = new LatLng(39.476333263079695,-0.3753375500000402); 
			LugaresDeInteres_Item basilicaVirgenDesamparados =  new LugaresDeInteres_Item(
					PLAZA_VIRGEN,
					contexto.getString(R.string.basilicaPlazaDeLaVirgen), 
					contexto.getString(R.string.basilicaPlazaDeLaVirgenContent), 
					contexto.getString(R.string.Monumentos),
					latlng, 
					contexto.getString(R.string.basilicaPlazaDeLaVirgenAddress),
					contexto.getString(R.string.basilicaPlazaDeLaVirgenPrice),
					contexto.getString(R.string.basilicaPlazaDeLaVirgenHorary),
					contexto.getString(R.string.basilicaPlazaDeLaVirgenTelephone),
					R.drawable.lugaresdeinteres_ficha_plazavirgen, 
					arrayGallery
					);
			
			latlng = new LatLng(39.47526494758923,-0.37548775370488396); 
			LugaresDeInteres_Item micalet =  new LugaresDeInteres_Item(
					MICALET,
					contexto.getString(R.string.micalet), 
					contexto.getString(R.string.micaletContent), 
					contexto.getString(R.string.Monumentos),
					latlng, 
					contexto.getString(R.string.micaletAddress),
					contexto.getString(R.string.micaletPrice),
					contexto.getString(R.string.micaletHorary),
					contexto.getString(R.string.micaletTelephone),
					R.drawable.lugaresdeinteres_ficha_elmicalet, 
					arrayGallery
					);
			
			
			arrayList.add(lonjaDeLaSeda);
			arrayList.add(torresDeSerranos);
			arrayList.add(torresDeQuart);
			arrayList.add(mercadoCentral);
			arrayList.add(mercadoColon);
			arrayList.add(ciudadartesyciencias);
			arrayList.add(plazaAyuntamiento);
			arrayList.add(estacionNorte);
			arrayList.add(plazaToros);
			arrayList.add(basilicaVirgenDesamparados);
			arrayList.add(micalet);

		return arrayList;
		
	}
	
	//devolver lista de lugares de interes - Ciudad de las Artes y las Ciencias
		public static ArrayList<LugaresDeInteres_Item> obtainCAC(Context contexto){
				arrayList = new ArrayList<LugaresDeInteres_Item>();
				//sobreescribir estas variables que contendr�n otra informaci�n como la latlong y las imagenes
				//que leer� de la sd.
				latlng = new LatLng(39.47434857729124, -0.3785929481113093);
				arrayGallery = new int[]{R.drawable.main_bg_1, R.drawable.main_bg_2, R.drawable.main_bg_3, R.drawable.main_bg_4, R.drawable.main_bg_5};
				LugaresDeInteres_Item hemisferic =  new LugaresDeInteres_Item(
						HEMISFERIC,
						contexto.getString(R.string.hemisferic), 
						contexto.getString(R.string.hemisfericContent), 
						contexto.getString(R.string.cac),
						latlng, 
						contexto.getString(R.string.hemisfericAddress),
						contexto.getString(R.string.hemisfericPrice),
						contexto.getString(R.string.hemisfericHorary),
						contexto.getString(R.string.hemisfericTelephone),
						R.drawable.lugaresdeinteres_hemisferic, 
						arrayGallery
						);
				
				latlng = new LatLng(39.47913178119177,-0.37600058732025765);
				LugaresDeInteres_Item torresDeSerranos =  new LugaresDeInteres_Item(
						MUSEO_DE_LAS_CIENCIAS,
						contexto.getString(R.string.museoDeLasCiencias), 
						contexto.getString(R.string.museoDeLasCienciasContent), 
						contexto.getString(R.string.cac),
						latlng, 
						contexto.getString(R.string.museoDeLasCienciasAddress),
						contexto.getString(R.string.museoDeLasCienciasPrice),
						contexto.getString(R.string.museoDeLasCienciasHorary),
						contexto.getString(R.string.museoDeLasCienciasTelephone),
						R.drawable.lugaresdeinteres_museoprincipefelipe, 
						arrayGallery
						);
				
				latlng = new LatLng(39.47574166307943,-0.3841759499999853); 
				LugaresDeInteres_Item torresDeQuart =  new LugaresDeInteres_Item(
						OCEANOGRAFIC,
						contexto.getString(R.string.oceanografic), 
						contexto.getString(R.string.oceanograficContent), 
						contexto.getString(R.string.cac),
						latlng, 
						contexto.getString(R.string.oceanograficAddress),
						contexto.getString(R.string.oceanograficPrice),
						contexto.getString(R.string.oceanograficHorary),
						contexto.getString(R.string.oceanograficTelephone),
						R.drawable.lugaresdeinteres_oceanografic, 
						arrayGallery
						);
				
				latlng = new LatLng(39.473612081180725,-0.3793405272460859); 
				LugaresDeInteres_Item mercadoCentral =  new LugaresDeInteres_Item(
						PALAU_DE_LES_ARTS,
						contexto.getString(R.string.palauDeLesArts), 
						contexto.getString(R.string.palauDeLesArtsContent), 
						contexto.getString(R.string.cac),
						latlng, 
						contexto.getString(R.string.palauDeLesArtsAddress),
						contexto.getString(R.string.palauDeLesArtsPrice),
						contexto.getString(R.string.palauDeLesArtsHorary),
						contexto.getString(R.string.palauDeLesArtsTelephone),
						R.drawable.lugaresdeinteres_palaudelesarts, 
						arrayGallery
						);
				
				latlng = new LatLng(39.46880596688192,-0.3688555079345468);
				LugaresDeInteres_Item mercadoColon =  new LugaresDeInteres_Item(
						UMBRACLE,
						contexto.getString(R.string.umbracle), 
						contexto.getString(R.string.umbracleContent), 
						contexto.getString(R.string.cac),
						latlng, 
						contexto.getString(R.string.umbracleAddress),
						contexto.getString(R.string.umbraclePrice),
						contexto.getString(R.string.umbracleHorary),
						contexto.getString(R.string.umbracleTelephone),
						R.drawable.lugaresdeinteres_umbracle, 
						arrayGallery
						);
				
				latlng = new LatLng(39.45697498085445,-0.3526350330353045); 
				LugaresDeInteres_Item ciudadartesyciencias =  new LugaresDeInteres_Item(
						AGORA,
						contexto.getString(R.string.agora), 
						contexto.getString(R.string.agoraContent), 
						contexto.getString(R.string.cac),
						latlng, 
						contexto.getString(R.string.agoraAddress),
						contexto.getString(R.string.agoraPrice),
						contexto.getString(R.string.agoraHorary),
						contexto.getString(R.string.agoraTelephone),
						R.drawable.lugaresdeinteres_agora, 
						arrayGallery
						);
	
				
				arrayList.add(hemisferic);
				arrayList.add(torresDeSerranos);
				arrayList.add(torresDeQuart);
				arrayList.add(mercadoCentral);
				arrayList.add(mercadoColon);
				arrayList.add(ciudadartesyciencias);
				

			return arrayList;
			
		}
		

}
