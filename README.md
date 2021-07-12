# buildship-annotation-processing

This is an example of a working annotation processing with a Gradle build on 
Eclipse and VSCode.  

## Background
I have a project which requires Lombok and Mapstruct.  Both leverages Gradle's `annotationProcessor`.  I also was using Spring Boot which demostrated more issues with this.  Using IntelliJ IDEA I am able to import a project leveraging this without any issues.  However, the same could not be said with Eclipse and VSCode.

Upon running a Java main or test class, Spring produce the following error:
```
***************************
APPLICATION FAILED TO START
***************************

Description:

Parameter 0 of constructor in com.pattycake.example.MyApplication required a bean of type 'com.pattycake.example.core.BuildingMapper' that could not be found.
```

VSCode uses Buildship is used under the hood according to vscode-java issue [1039](https://github.com/redhat-developer/vscode-java/issues/1039).  Buildship has open issue [329](https://github.com/eclipse/buildship/issues/329) to support annotation processing.  This explains why Eclipse and VSCode demostrated
the same behavior.

# Work around
 
I've added the following to `build.gradle`. 

```
plugins {
  id "com.diffplug.eclipse.apt" version "3.30.0"
}

subprojects {
    apply plugin: 'com.diffplug.eclipse.apt'

    eclipse {
        classpath {
            file.beforeMerged { cp ->
                cp.entries.add( new org.gradle.plugins.ide.eclipse.model.SourceFolder('.apt_generated', null) )
            }
        }
    }
}
```

In Eclipse, I imported the project as a Gradle project.  In VSCode, I open the folder into a new window.