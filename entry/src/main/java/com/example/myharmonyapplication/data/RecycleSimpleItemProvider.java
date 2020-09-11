package com.example.myharmonyapplication.data;

import com.example.myharmonyapplication.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.agp.components.*;

import java.util.List;

public class RecycleSimpleItemProvider extends RecycleItemProvider {
    private List<RecycleInfo> mListInfo;

    private AbilitySlice mSlice;

    private LayoutScatter mLayoutScatter;

    public RecycleSimpleItemProvider(List<RecycleInfo> mListInfo, AbilitySlice slice) {
        this.mListInfo = mListInfo;
        this.mSlice = slice;
        this.mLayoutScatter = LayoutScatter.getInstance(mSlice);
    }

    @Override
    public int getCount() {
        return mListInfo.size();
    }

    public Object getItem(int position) {
        return mListInfo.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Component getComponent(int position, Component component, ComponentContainer componentContainer) {
        RecycleInfo info = (RecycleInfo) getItem(position);

        if (component != null) {
            return component;
        }

        Component newComponent = mLayoutScatter.parse(ResourceTable.Layout_actionbar_item, null, false);
        Text leftText = (Text) newComponent.findComponentById(ResourceTable.Id_list_text_left);
        Text rightText = (Text) newComponent.findComponentById(ResourceTable.Id_list_text_right);
        leftText.setText(info.getLeftTitle());
        rightText.setText(info.getRightTitle());
        return newComponent;
    }
}
