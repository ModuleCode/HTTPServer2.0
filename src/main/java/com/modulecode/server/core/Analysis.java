package com.modulecode.server.core;

import com.modulecode.server.definition.Project;

import java.util.ArrayList;

public interface Analysis {
    int getPort();

    ArrayList<Project> getProjects();


}
