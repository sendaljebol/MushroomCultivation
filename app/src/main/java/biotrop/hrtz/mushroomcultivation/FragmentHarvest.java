package biotrop.hrtz.mushroomcultivation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;


/**
 * Created by Webmaster on 9/13/2016.
 */
public class FragmentHarvest extends Fragment{
    private TextView tvAlat, tvCara;
    private WebView displayVideo;

    // The onCreateView method is called when Fragment should create its View object hierarchy,
    // either dynamically or via XML layout inflation.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
      return inflater.inflate(R.layout.content_harvest, parent, false);
    }

    // This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {


        // Setup any handles to view objects here

        tvAlat = (TextView)view.findViewById(R.id.harvest_tv_alatbahan);
        tvCara = (TextView)view.findViewById(R.id.harvest_tv_procedure);

        String alat = getResources().getString(R.string.harvest_tool);
        tvAlat.setText(Html.fromHtml(alat, null, new MyTagHandler()));
        String langkah = getResources().getString(R.string.harvest_procedure);
        tvCara.setText(Html.fromHtml(langkah, null, new MyTagHandler()));

        DisplayMetrics metrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
        displayVideo = (WebView)view.findViewById(R.id.youtube_fragment_harvest);
        String frameVideo = "<html>" +
                "<iframe style='display: block; max-width:100%;' src=\"https://www.youtube.com/embed/W0UsDBBE1kI\"" +
                " frameborder=\"0\" allowfullscreen></iframe></html>";
        Log.d("width", frameVideo);
        displayVideo.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        WebSettings webSettings = displayVideo.getSettings();
        webSettings.setJavaScriptEnabled(true);

        displayVideo.loadData(frameVideo, "text/html", "utf-8");
    }

    public void cvClicked(View v){

    }

    @Override
    public void onPause() {
        super.onPause();
        displayVideo.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        displayVideo.onResume();
    }
}
