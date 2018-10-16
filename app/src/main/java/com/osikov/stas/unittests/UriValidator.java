package com.osikov.stas.unittests;

import android.content.Context;

import java.net.URI;

public class UriValidator {

    private final Context context;

    public UriValidator(Context context) {
        this.context = context;
    }

    public String validate(String uri) {
        int resId = R.string.nothing;
        if (isUrl(uri)) {
            resId = R.string.url;
        } else if (isFile(uri)) {
            resId = R.string.file;
        }
        return context.getString(resId);
    }

    private boolean isUrl(String uri) {
        return "http".equals(URI.create(uri).getScheme());
    }

    private boolean isFile(String uri) {
        return "file".equals(URI.create(uri).getScheme());
    }
}
