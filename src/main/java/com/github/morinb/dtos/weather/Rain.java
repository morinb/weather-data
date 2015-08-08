package com.github.morinb.dtos.weather;

import java.io.Serializable;

public class Rain implements Serializable{
    private int _3h;

    public Rain() {
    }

    public int get_3h() {
        return _3h;
    }

    public void set_3h(int _3h) {
        this._3h = _3h;
    }
}
