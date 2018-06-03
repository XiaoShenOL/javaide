package com.duy.android.compiler.builder.task.java;

import com.duy.android.compiler.builder.IBuilder;
import com.duy.android.compiler.builder.task.ATask;
import com.duy.android.compiler.java.JarArchive;
import com.duy.android.compiler.project.JavaProject;

public class JarTask extends ATask<JavaProject> {
    public JarTask(IBuilder<JavaProject> builder) {
        super(builder);
    }

    @Override
    public String getTaskName() {
        return "Create jar archive";
    }

    @Override
    public boolean run() throws Exception {
        //now create normal jar file
        JarArchive jarArchive = new JarArchive(builder.isVerbose());
        jarArchive.createJarArchive(project);
        return true;
    }
}