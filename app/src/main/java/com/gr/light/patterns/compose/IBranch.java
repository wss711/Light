package com.gr.light.patterns.compose;

import java.util.ArrayList;

public interface IBranch extends ICorp {
    void addSubordinate(ICorp corp);
    ArrayList<ICorp> getSubordinate();
}
