package vit.collegecode.mediadb.fragments;

import vit.collegecode.mediadb.*;
import vit.collegecode.mediadb.data.BitmapScale;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class PagerFragment extends Fragment {
	
	int[] movies_poster={R.drawable.im,R.drawable.got,R.drawable.ca};
	int[] movies_landscape={R.drawable.iml,R.drawable.gotl,R.drawable.cal};
	int position;
	Context mActivity;
	public PagerFragment(){
		
	}
	
	public PagerFragment(int _position){
		position=_position;
	}
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		
		RelativeLayout v = (RelativeLayout)inflater.inflate(R.layout.pageritem, null);
		TextView movietype =(TextView)v.findViewById(R.id.textView1);
		movietype.setTypeface(Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto-Light.ttf"));
		ImageView poster = (ImageView)v.findViewById(R.id.imageView1);
		ImageView landscape = (ImageView)v.findViewById(R.id.imageView2);
		BitmapScale bs1 = new BitmapScale(getActivity());
		BitmapScale bs2 = new BitmapScale(getActivity());
		poster.setImageBitmap(bs1.decodeSampledBitmapFromResource(getResources(), movies_poster[position], 100, 184));
		landscape.setImageBitmap(bs2.decodeSampledBitmapFromResource(getResources(), movies_landscape[position], 250, 184));
		return v;
		
	}
}
