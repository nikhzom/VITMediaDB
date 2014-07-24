package vit.collegecode.mediadb;





import vit.collegecode.mediadb.fragments.HomePageFragment;
import vit.collegecode.mediadb.helpers.FadingActionBarHelper;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

public class MainActivity extends FragmentActivity {
	
	public FadingActionBarHelper mActionBarHelper;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		mActionBarHelper = new FadingActionBarHelper(getActionBar(), getResources().getDrawable(R.drawable.actionbar_bg));
		getActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbar_bg));
		Log.i("test", "Successful Test");
		getSupportFragmentManager().beginTransaction().add(R.id.content_frame, new HomePageFragment()).commit();
	}
	
	public FadingActionBarHelper getFadingActionBarHelper() {
		// TODO Auto-generated method stub
		return mActionBarHelper;
	}
}
