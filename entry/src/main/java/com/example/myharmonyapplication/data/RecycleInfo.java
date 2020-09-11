package com.example.myharmonyapplication.data;

public class RecycleInfo {

    private String leftTitle;

    private String rightTitle;

    private RecycleInfo(String leftTitle, String rightTitle) {
        this.leftTitle = leftTitle;
        this.rightTitle = rightTitle;
    }

    public String getLeftTitle() {
        return leftTitle;
    }

    public String getRightTitle() {
        return rightTitle;
    }

    public static class Builder {
        private String leftTitle;

        private String rightTitle;

        public RecycleInfo build() {
            return new RecycleInfo(leftTitle, rightTitle);
        }

        public Builder leftTitle1(String leftTitle) {
            this.leftTitle = leftTitle;
            return this;
        }

        public Builder rightTitle(String rightTitle) {
            this.rightTitle = rightTitle;
            return this;
        }
    }
}
