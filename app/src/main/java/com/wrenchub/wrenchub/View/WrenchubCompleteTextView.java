package com.wrenchub.wrenchub.View;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import com.wrenchub.wrenchub.R;


public class WrenchubCompleteTextView extends android.support.v7.widget.AppCompatAutoCompleteTextView {
    public WrenchubCompleteTextView(Context context) {
        super(context);
    }

    public WrenchubCompleteTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public WrenchubCompleteTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init(AttributeSet attr){
        if(attr!=null) {
            TypedArray typedarray = getContext().obtainStyledAttributes(attr, R.styleable.WrenchubCompleteTextView);
            String fontName=typedarray.getString(R.styleable.WrenchubCompleteTextView_fontName);
            if(fontName!=null){
                setTypeface(Typefaces.getTypeFace(getContext(),fontName));
            }
            typedarray.recycle();

        }
    }
}
