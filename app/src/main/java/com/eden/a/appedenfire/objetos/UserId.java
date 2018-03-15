package com.eden.a.appedenfire.objetos;

import android.support.annotation.NonNull;

/**
 * Created by a on 10/03/2018.
 */

public class UserId {
    public String userId;

    public <T extends UserId> T widthId(@NonNull final String id){
        this.userId=id;
        return (T) this;
    }
}
