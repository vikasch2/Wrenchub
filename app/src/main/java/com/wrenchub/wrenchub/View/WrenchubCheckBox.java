package com.wrenchub.wrenchub.View;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatCheckBox;
import android.util.AttributeSet;

import com.wrenchub.wrenchub.R;


public class WrenchubCheckBox extends AppCompatCheckBox {
    public WrenchubCheckBox(Context context) {
        super(context);
        init(null);
    }

    public WrenchubCheckBox(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public WrenchubCheckBox(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }


    private void init(AttributeSet attrs){
        if (attrs != null){
            TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.WrenchubCheckBox);
            String fontName = typedArray.getString(R.styleable.WrenchubCheckBox_fontName);
            if (fontName != null){
                setTypeface(Typefaces.getTypeFace(getContext(),fontName));
            }
            typedArray.recycle();

        }
    }

}
