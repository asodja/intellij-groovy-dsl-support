package mytasks;

import org.gradle.api.DefaultTask;
import org.gradle.api.file.ConfigurableFileCollection;
import org.gradle.api.provider.Property;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.InputFiles;
import org.gradle.api.tasks.TaskAction;

public abstract class MyTask extends DefaultTask {
    @Input
    public abstract Property<String> getMyFirstProperty();
    private final Property<String> mySecondProperty;
    @Input
    public Property<String> getMySecondProperty() {
        return mySecondProperty;
    }
    @InputFiles
    public abstract ConfigurableFileCollection getMyCollection();

    public MyTask() {
        mySecondProperty = getProject().getObjects().property(String.class);
    }

    @TaskAction
    public void run() {
        System.out.println("MySecondProperty: " + getMyFirstProperty().getOrNull());
        System.out.println("MyThirdProperty: " + getMySecondProperty().getOrNull());
        System.out.println("MySecondCollection: " + getMyCollection().getFiles());
    }
}