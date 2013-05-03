package dam.project.wearevalencia;


import com.slidingmenu.lib.SlidingMenu;
import com.slidingmenu.lib.app.SlidingFragmentActivity;
import dam.project.wearevalencia.fragments.Main_Content_Fragment;
import dam.project.wearevalencia.fragments.Sliding_Menu_Fragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;


public class Main_FragmentActivity extends SlidingFragmentActivity{
	private Fragment mContent;
	static SlidingMenu slidingMenu;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setBehindContentView(R.layout.sliding_menu_frame_list);
		//set the above view
		if(savedInstanceState != null)
			mContent = getSupportFragmentManager().getFragment(savedInstanceState, "content");
		
		if(mContent == null)
			mContent = new Main_Content_Fragment();
				
		setContentView(R.layout.main_frame_activity);
	
		//reemplazada la vista "contenedora" por la vista "main_content_activity"
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		ft.replace(R.id.content_fragment, mContent).commit();
	
		// que se deslize el actionbar
		setSlidingActionBarEnabled(true); 
		// es igual que: ->  //slidingMenu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT); //deslizar todo menos el actionbar
		
		SlidingMenuAction();
				
		//reemplazar la vista del sliding menu
		ft = getSupportFragmentManager().beginTransaction();
		ft.replace(R.id.sliding_menu_fragment, new Sliding_Menu_Fragment()).commit();
		
		
	}
	

	private void SlidingMenuAction() {
		//configurar slidingMenu
		slidingMenu = getSlidingMenu();
		slidingMenu.setShadowDrawable(R.drawable.shadow);
		slidingMenu.setShadowWidthRes(R.dimen.shadow_width);
		slidingMenu.setBehindOffset(80);
		slidingMenu.setMode(SlidingMenu.LEFT);
		slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		slidingMenu.setFadeDegree(0.10f);
		slidingMenu.setBehindScrollScale(0);

	
		
	}
	
	//devuelve la referencia al objeto de esta clase, con lo cual en las otras clases de donde querramos abrir el men�
	//solo habr� que instanciar el objeto.
	public static SlidingMenu putReference(){
		return slidingMenu;
	}
}
