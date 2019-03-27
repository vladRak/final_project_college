package com.final_project_college.annotation.processor;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;
import java.util.Set;

@SupportedAnnotationTypes({"Credentials"})
@SupportedSourceVersion(SourceVersion.RELEASE_8)
//@AutoService(Processor.class)
public class CredentialsProcessor extends AbstractProcessor {

    //            private Filer filer;
    private Messager messager;
    private Types typeUtils;
    private Elements elementsUtils;

    @Override
    public void init(ProcessingEnvironment env) {
        super.init(env);
//        filer = env.getFiler();
        messager = env.getMessager();
        typeUtils = this.processingEnv.getTypeUtils();
        elementsUtils = this.processingEnv.getElementUtils();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations,
                           RoundEnvironment env) {

        for (TypeElement ann : annotations) {

            Set<? extends Element> e2s = env.getElementsAnnotatedWith(ann);

            TypeMirror tm = elementsUtils.getTypeElement("Controller").asType();

            for (Element e2 : e2s) {
                // Class or super of Class using @Credentials
                // must implement interface Controller
                if (!typeUtils.isSubtype(e2.asType(), tm)) {
                    messager.printMessage(
                            Diagnostic.Kind.ERROR,
                            "Class or super of Class using @Credentials " +
                                    "must implement interface Controller",
                            e2);
                }
            }
        }
        return true;
    }


    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }
}