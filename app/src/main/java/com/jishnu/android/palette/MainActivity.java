package com.jishnu.android.palette;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mVibrantTextView;
    private TextView mLightVibrantTextView;
    private TextView mDarkVibrantTextView;
    private TextView mMutedTextView;
    private TextView mLightMutedTextView;
    private TextView mDarkMutedTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView( R.layout.activity_main );

        initViews();

        Bitmap bitmap = BitmapFactory.decodeResource( getResources(), R.drawable.dog_image );
        Palette.from( bitmap ).generate( new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated( Palette palette ) {

                setViewSwatch( mVibrantTextView, palette.getVibrantSwatch() );
                setViewSwatch( mLightVibrantTextView, palette.getLightVibrantSwatch() );
                setViewSwatch( mDarkVibrantTextView, palette.getDarkVibrantSwatch() );
                setViewSwatch( mMutedTextView, palette.getMutedSwatch() );
                setViewSwatch( mLightMutedTextView, palette.getLightMutedSwatch() );
                setViewSwatch( mDarkMutedTextView, palette.getDarkMutedSwatch() );
            }
        });
    }

    public void setViewSwatch(TextView view, Palette.Swatch swatch ) {
        if( swatch != null ) {
            view.setTextColor( swatch.getTitleTextColor() );
            view.setBackgroundColor( swatch.getRgb() );
            view.setVisibility( View.VISIBLE );
        } else {
            view.setVisibility( View.GONE );
        }
    }

    private void initViews() {
        mVibrantTextView = (TextView) findViewById( R.id.vibrant );
        mLightVibrantTextView = (TextView) findViewById( R.id.light_vibrant );
        mDarkVibrantTextView = (TextView) findViewById( R.id.dark_vibrant );
        mMutedTextView = (TextView) findViewById( R.id.muted );
        mLightMutedTextView = (TextView) findViewById( R.id.light_muted );
        mDarkMutedTextView = (TextView) findViewById( R.id.dark_muted );
    }
}