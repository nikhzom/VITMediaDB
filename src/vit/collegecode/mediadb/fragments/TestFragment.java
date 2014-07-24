package vit.collegecode.mediadb.fragments;

import java.lang.ref.WeakReference;

import vit.collegecode.mediadb.MainActivity;
import vit.collegecode.mediadb.R;
import vit.collegecode.mediadb.fragments.HomePageFragment.CustomAdapter;
import vit.collegecode.mediadb.views.CustomItemCard;
import android.app.Activity;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cards_ui.Card;
import com.example.cards_ui.CardAdapter;
import com.example.cards_ui.CardHeader;
import com.example.cards_ui.CardListView;


public class TestFragment extends HeaderFragment {
	
	private CardListView mListView;
	private CardAdapter<Card> adapter;
    private String[] mListViewTitles;
    private AsyncLoadSomething mAsyncLoadSomething;
    private CustomAdapter page_adapter;
    
	  @Override
	    public void onAttach(Activity activity) {
	        super.onAttach(activity);
	        adapter = new CardAdapter<Card>(getActivity(),android.R.color.holo_blue_dark);
	        setHeaderBackgroundScrollMode(HEADER_BACKGROUND_SCROLL_PARALLAX);
	        setOnHeaderScrollChangedListener(new OnHeaderScrollChangedListener() {
	            @Override
	            public void onHeaderScrollChanged(float progress, int height, int scroll) {
	                height -= getActivity().getActionBar().getHeight();

	                progress = (float) scroll / height;
	                if (progress > 1f) progress = 1f;

	                // *
	                // `*
	                // ```*
	                // ``````*
	                // ````````*
	                // `````````*
	                progress = (1 - (float) Math.cos(progress * Math.PI)) * 0.5f;

	                ((MainActivity) getActivity())
	                        .getFadingActionBarHelper()
	                        .setActionBarAlpha((int) (255 * progress));
	            }
	        });
	        cancelAsyncTask(mAsyncLoadSomething);
	        mAsyncLoadSomething = new AsyncLoadSomething(this);
	        mAsyncLoadSomething.execute();
	    }
	  
	  
	  @Override
	    public void onDetach() {
		  cancelAsyncTask(mAsyncLoadSomething);
	        super.onDetach();
	    }
	  
	

	@Override
	public View onCreateContentView(LayoutInflater inflater, ViewGroup container) {
		// TODO Auto-generated method stub
		mListView = (CardListView) inflater.inflate(R.layout.fragment_listview, container, false);
		return mListView;
	}

	@Override
	public View onCreateHeaderView(LayoutInflater inflater, ViewGroup container) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.fragment_header, container, false);
	}

	@Override
	public View onCreateContentOverlayView(LayoutInflater arg0, ViewGroup arg1) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void addCards(String[] titles) {
		mListViewTitles=titles; 
		
		adapter.add(new CustomItemCard(getActivity(), "Description"));
		adapter.add(new CardHeader("Users"));
		for(int i=0;i<mListViewTitles.length;i++)
		{
			adapter.add(new Card(mListViewTitles[i]).setThumbnail(getResources().getDrawable(R.drawable.profile)));
		}
		
        mListView.setVisibility(View.VISIBLE);
        mListView.setAdapter(adapter);
        setListViewAdapter(mListView, adapter);
    }
	
	private void cancelAsyncTask(AsyncTask task) {
        if (task != null) task.cancel(false);
    }
	
	private static class AsyncLoadSomething extends AsyncTask<Void, Void, String[]> {

        private static final String TAG = "AsyncLoadSomething";

        final WeakReference<TestFragment> weakFragment;

        public AsyncLoadSomething(TestFragment fragment) {
            this.weakFragment = new WeakReference<TestFragment>(fragment);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            final TestFragment audioFragment = weakFragment.get();
//            if (audioFragment.mListView != null) audioFragment.mListView.setVisibility(View.INVISIBLE);
        }

        @Override
        protected String[] doInBackground(Void... voids) {

            return new String[]{"Placeholder", "Placeholder", "Placeholder", "Placeholder",
                    "Placeholder", "Placeholder", "Placeholder", "Placeholder",
                    "Placeholder", "Placeholder", "Placeholder", "Placeholder",
                    "Placeholder", "Placeholder", "Placeholder", "Placeholder",
                    "Placeholder", "Placeholder", "Placeholder", "Placeholder",
                    "Placeholder", "Placeholder", "Placeholder", "Placeholder"};
        }

        @Override
        protected void onPostExecute(String[] titles) {
            super.onPostExecute(titles);
            final TestFragment audioFragment = weakFragment.get();
            audioFragment.addCards(titles);
        }
    }
	
	@Override
	public void onDestroy(){
		super.onDestroy();
		((MainActivity) getActivity())
        .getFadingActionBarHelper()
        .setActionBarAlpha(255);
	}
}
