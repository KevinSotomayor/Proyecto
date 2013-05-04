package dam.project.wearevalencia;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

/* Clase que se inicia y muestra una pantalla de espera mientras se carga la aplicacion
 * basada en la aplicaci�n de ODEC (FCT) */


public class SplashScreen_Inicio extends Activity {
	private final int DELAY_MILIS = 1000;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splashscreen_inicio);
		
		Typeface robotoSplash = Typeface.createFromAsset(getAssets(), "Roboto-Thin.ttf");
		TextView cargando = (TextView)findViewById(R.id.splashScreen_textView);
		cargando.setTypeface(robotoSplash);

			new Handler().postDelayed(new Runnable() {
							
				@Override
				public void run() {
					Intent mainScreen = new Intent(SplashScreen_Inicio.this, Main_FragmentActivity.class);
					mainScreen.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(mainScreen);
					overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

					//el nuevo intent elimina las actividades que est� creadas por encima de esta.
					/*Si se establece, y la actividad que se puso en marcha est� en ejecuci�n en la tarea actual, en lugar de lanzar una nueva instancia de la actividad,
					 *  todas las dem�s actividades de la parte superior de la misma se cerrar� y la intenci�n ser� 
					 *  entregado a la (ahora en superior) actividad antigua como nueva Intenci�n.

					* Por ejemplo, considere una tarea que consiste en las actividades: A, B, C, D. 
					* Si D llama startActivity () con la intenci�n que 
					* tiene el componente de la actividad B, C y D se terminar� y B reciben la intenci�n dada ,
					* lo que resulta en la pila ahora siendo: a, B.
					* 
					* http://developer.android.com/intl/es/reference/android/content/Intent.html#FLAG_ACTIVITY_CLEAR_TOP
					 */
					
					SplashScreen_Inicio.this.finish();
				}
			}, DELAY_MILIS);
			
		}
	
}
