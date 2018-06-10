package com.duy.ide.javaide.editor.autocomplete.model;

import com.duy.ide.editor.view.CodeEditor;
import com.duy.ide.javaide.editor.autocomplete.util.JavaUtil;

import java.lang.reflect.Constructor;

/**
 * Created by Duy on 20-Jul-17.
 */

public class ConstructorDescription extends DescriptionImpl {
    private Constructor constructor;
    private String simpleName;
    private String packageName;

    public ConstructorDescription(Constructor constructor) {
        this.constructor = constructor;
        this.simpleName = JavaUtil.getSimpleName(constructor.getName());
        this.packageName = JavaUtil.getPackageName(constructor.getName());
    }


    @Override
    public String getName() {
        return constructor.getName();
    }

    @Override
    public char getTypeHeader() {
        return 'c'; //class
    }

    @Override
    public String getDescription() {
        return packageName;
    }

    @Override
    public String getReturnType() {
        return "";
    }

    @Override
    public String getInsertText() {
        if (constructor.getParameterTypes().length > 0) {
            return simpleName + "(" + CodeEditor.CURSOR + ");";
        } else {
            return simpleName + "();" + CodeEditor.CURSOR;
        }
    }


    @Override
    public String toString() {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        StringBuilder params = new StringBuilder();
        for (int i = 0; i < parameterTypes.length; i++) {
            Class<?> parameterType = parameterTypes[i];
            if (i == parameterTypes.length - 1) {
                params.append(parameterType.getSimpleName());
                break;
            }
            params.append(parameterType.getSimpleName()).append(",");
        }
        return JavaUtil.getSimpleName(constructor.getName()) + "(" + params.toString() + ")";
    }
}
