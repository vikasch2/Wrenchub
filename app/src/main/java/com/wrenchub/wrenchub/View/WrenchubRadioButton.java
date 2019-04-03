package com.wrenchub.wrenchub.View;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatRadioButton;
import android.util.AttributeSet;

import com.wrenchub.wrenchub.R;


public class WrenchubRadioButton extends AppCompatRadioButton {
    public WrenchubRadioButton(Context context) {
        super(context);
        init(null);
    }

    public WrenchubRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(null);
    }

    public WrenchubRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(null);
    }
    private void init(AttributeSet attr){
        if(attr!=null) {
            TypedArray typedArray = getContext().obtainStyledAttributes(attr, R.styleable.WrenchubRadioButton);
            String fontName=typedArray.getString(R.styleable.WrenchubRadioButton_fontName);
            if(fontName!=null){
                setTypeface(Typefaces.getTypeFace(getContext(),fontName));
            }
            typedArray.recycle();
        }
    }
}
