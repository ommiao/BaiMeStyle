package me.iacn.mbestyle.ui.fragment;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;

import me.iacn.mbestyle.BuildConfig;
import me.iacn.mbestyle.R;
import me.iacn.mbestyle.ui.activity.LicenseActivity;
import me.iacn.mbestyle.ui.widget.AboutItem;
import me.iacn.mbestyle.util.GlideUtils;

/**
 * Created by iAcn on 2017/2/18
 * Email i@iacn.me
 */

public class AboutFragment extends BaseFragment implements View.OnClickListener {

    private ImageView ivLogo;
    private AboutItem aiVersion;
    private AboutItem aiOpenSource;

    @Override
    protected int getContentView() {
        return R.layout.fragment_about;
    }

    @Override
    protected void findView() {
        ivLogo = (ImageView) findViewById(R.id.iv_logo);
        aiVersion = (AboutItem) findViewById(R.id.ai_version);
        aiOpenSource = (AboutItem) findViewById(R.id.ai_open_source);
    }

    @Override
    protected void setListener() {
        aiVersion.setOnClickListener(this);
        aiOpenSource.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        aiVersion.setSummary(BuildConfig.VERSION_NAME);
        GlideUtils.with(this).showImage(R.drawable.bg_about_logo, ivLogo);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.ai_open_source) {
            startActivity(new Intent(getActivity(), LicenseActivity.class));
        }
    }

    private void openUrl(String url) {
        try {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse(url)).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
        }
    }
}