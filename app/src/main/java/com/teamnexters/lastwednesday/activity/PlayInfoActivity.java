package com.teamnexters.lastwednesday.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.teamnexters.lastwednesday.R;
import com.teamnexters.lastwednesday.databinding.ActivityPlayInfoBinding;
import com.teamnexters.lastwednesday.model.Play;

public class PlayInfoActivity extends AppCompatActivity {

    ActivityPlayInfoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_play_info);
        binding.setActivity(this);

        Intent intent = getIntent();
        binding.setObj((Play) intent.getSerializableExtra("OBJECT"));
        binding.imagePlayTicket.setImageDrawable(getResources().getDrawable(binding.getObj().getPoster()));

        BitmapDrawable drawable = (BitmapDrawable) (getResources().getDrawable(binding.getObj().getPoster()));
        binding.imagePlayTicket.setImageBitmap(imageBlur(drawable.getBitmap(), 25));
    }

    public Bitmap imageBlur(Bitmap sentBitmap, int radius) {
        Bitmap bitmap = sentBitmap.copy(sentBitmap.getConfig(), true);

        final RenderScript rs = RenderScript.create(this);
        final Allocation input = Allocation.createFromBitmap(rs, sentBitmap, Allocation.MipmapControl.MIPMAP_NONE,
                Allocation.USAGE_SCRIPT);
        final Allocation output = Allocation.createTyped(rs, input.getType());
        final ScriptIntrinsicBlur script = ScriptIntrinsicBlur.create(rs, Element.U8_4(rs));
        script.setRadius(radius); //0.0f ~ 25.0f
        script.setInput(input);
        script.forEach(output);
        output.copyTo(bitmap);
        return bitmap;
    }


    public void onSubMenuClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.text_play_wishlist:
                Toast.makeText(getApplicationContext(), "위시리스트에 추가했습니다", Toast.LENGTH_SHORT).show();
                binding.getObj().setWish(true);
                break;

        }
    }
}
