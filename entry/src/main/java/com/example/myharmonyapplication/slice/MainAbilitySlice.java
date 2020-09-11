package com.example.myharmonyapplication.slice;

import com.example.myharmonyapplication.ResourceTable;
import com.example.myharmonyapplication.data.RecycleInfo;
import com.example.myharmonyapplication.data.RecycleSimpleItemProvider;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.ComponentContainer;
import ohos.agp.components.LayoutScatter;
import ohos.agp.components.ListContainer;

import java.util.ArrayList;
import java.util.List;

public class MainAbilitySlice extends AbilitySlice {
    private ComponentContainer mRootLayout;

    private ListContainer mListContainer;

    private List<RecycleInfo> mListInfo = new ArrayList<>();

    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        initListData();
        mRootLayout = initSliceLayout();
        super.setUIContent(mRootLayout);
    }

    @Override
    protected void onActive() {
        super.onActive();
    }

    @Override
    protected void onInactive() {
        super.onInactive();
    }

    @Override
    protected void onForeground(Intent intent) {
        super.onForeground(intent);
    }

    @Override
    protected void onBackground() {
        super.onBackground();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    private ComponentContainer initSliceLayout() {
        ComponentContainer rootLayout = (ComponentContainer) LayoutScatter.getInstance(getContext())
                .parse(ResourceTable.Layout_actionbar, null, false);

        mListContainer = (ListContainer) rootLayout.findComponentById(ResourceTable.Id_list_container);

        RecycleSimpleItemProvider itemProvider = new RecycleSimpleItemProvider(mListInfo, this);
        itemProvider.setCacheSize(20);
        mListContainer.setItemProvider(itemProvider);

        return rootLayout;
    }

    private void initListData() {
        for (int i = 1; i < 10; i++) {
            mListInfo.add(new RecycleInfo.Builder().leftTitle1("List").rightTitle("Text " + i).build());
        }
    }
}
