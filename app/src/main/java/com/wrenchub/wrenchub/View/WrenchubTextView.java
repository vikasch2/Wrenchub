package com.wrenchub.wrenchub.View;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import com.wrenchub.wrenchub.R;


public class WrenchubTextView extends AppCompatTextView {
    public WrenchubTextView(Context context) {
        super(context);
        init(null);
    }

    public WrenchubTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public WrenchubTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }
    private void init(AttributeSet attr){
        if(attr!=null){
            TypedArray typedArray=getContext().obtainStyledAttributes(attr, R.styleable.WrenchubTextView);
            String fontName=typedArray.getString(R.styleable.WrenchubTextView_fontName);
            if(fontName!=null){
                setTypeface(Typefaces.getTypeFace(getContext(),fontName));
            }
            typedArray.recycle();
        }

    }
}
