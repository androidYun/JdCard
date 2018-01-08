package com.lgy.jdcard.weight;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.lgy.jdcard.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ${lgy} on 2017/11/2716:11
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public class PlusReduceMedicinesView extends LinearLayout {
    @BindView(R.id.iv_reduce)
    ImageView ivReduce;
    @BindView(R.id.ev_count)
    EditText evCount;
    @BindView(R.id.iv_plus)
    ImageView ivPlus;
    @BindView(R.id.tv_unit)
    TextView tvUnit;
    private final static int MAX_NUM = 9999;//最大数值

    private int stepCount = 1;//递增数量

    private int defalteCount = 0;//默认数量

    private int currentCount = defalteCount;

    private Context mContext;

    private ChangeMedicinesCountLintener changeMedicinesCountLintener;

    public PlusReduceMedicinesView(Context context) {
        super(context);
        this.mContext = context;
        initView(context);
        inflateData();
    }

    public PlusReduceMedicinesView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.OperaCountView);
        stepCount = typedArray.getInteger(R.styleable.OperaCountView_step_count, 1);
        defalteCount = typedArray.getInteger(R.styleable.OperaCountView_default_count, 1);
        typedArray.recycle();
        initView(context);
        inflateData();
    }

    public void initView(Context mContext) {
        this.mContext = mContext;
        View inflateview = LayoutInflater.from(mContext).inflate(R.layout.view_reduce_plus, this, true);
        ButterKnife.bind(this, inflateview);
    }

    public void inflateData() {
        changeState(true);
    }


    @OnClick({R.id.iv_reduce, R.id.iv_plus, R.id.tv_unit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_reduce:
                if (currentCount > 0) {
                    currentCount--;
                }
                changeState(true);
                break;
            case R.id.iv_plus:
                if (currentCount < MAX_NUM) {
                    currentCount++;
                }
                changeState(true);
                break;
            case R.id.tv_unit:
                evCount.setFocusableInTouchMode(true);
                evCount.setFocusable(true);
                evCount.requestFocus();
                InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(evCount, InputMethodManager.SHOW_FORCED);
                imm.toggleSoftInput(0, InputMethodManager.SHOW_FORCED);
                break;
        }

    }

    public void changeState(boolean needUpdate) {
        if (changeMedicinesCountLintener != null) {
            changeMedicinesCountLintener.changeCountSuccess(currentCount);
        }
        if (currentCount <= 1) {//最少数量为1
            ivReduce.setEnabled(false);
        } else {
            ivReduce.setEnabled(true);
        }

        if (currentCount < MAX_NUM) {
            ivPlus.setEnabled(true);
        } else {
            ivPlus.setEnabled(false);
        }
        if (needUpdate) {
            evCount.setText(String.valueOf(currentCount));
            evCount.setSelection(evCount.getText().toString().length());
        }
    }

    /**
     * 获取当前数量
     *
     * @return
     */
    public int getCurrentCount() {
        return currentCount;
    }

    /**
     * 设置数量
     *
     * @param count
     */
    public void setCurrentCount(int count) {
        this.currentCount = count;
        changeState(false);
    }


    public void setChangeMedicinesCountLintener(ChangeMedicinesCountLintener changeMedicinesCountLintener) {
        this.changeMedicinesCountLintener = changeMedicinesCountLintener;
    }

    public interface ChangeMedicinesCountLintener {
        void changeCountSuccess(int count);

    }

    public EditText getCountEv() {
        return evCount;
    }

}
