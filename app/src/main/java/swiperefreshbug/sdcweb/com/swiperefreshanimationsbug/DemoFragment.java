package swiperefreshbug.sdcweb.com.swiperefreshanimationsbug;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DemoFragment extends Fragment {
    SwipeRefreshLayout swipeRefreshLayout;

    public DemoFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.content_main, container, false);
        swipeRefreshLayout = (SwipeRefreshLayout) v.findViewById(R.id.swipeToRefresh);

        TextView textView = (TextView) v.findViewById(R.id.textView);
        textView.setText(getArguments().getString("count"));
        return v;
    }

    @Override
    public void onPause() {
        super.onPause();

        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setRefreshing(false);
            swipeRefreshLayout.destroyDrawingCache();
            swipeRefreshLayout.clearAnimation();
        }
    }
}
