package com.final_project_college.annotation.processor;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;
import java.util.Set;

@SupportedAnnotationTypes({"WebController"})
@SupportedSourceVersion(SourceVersion.RELEASE_8)
//@AutoService(Processor.class)
public class WebControllerProcessor extends AbstractProcessor {

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
                String className = e2.getSimpleName().toString();

                // @WebController only use for Class
                if (e2.getKind() != ElementKind.CLASS) {
                    messager.printMessage(
                            Diagnostic.Kind.ERROR,
                            "@WebController using for class only ",
                            e2);
                } else
                    // Class or super of Class using @WebController must implement interface Controller
                    if (!typeUtils.isSubtype(e2.asType(), tm)) {
                        messager.printMessage(
                                Diagnostic.Kind.ERROR,
                                "Class or super of Class using @WebController " +
                                        "must implement interface Controller",
                                e2);
                    } else
                        // @WebController using for class with suffix Controller
                        if (!className.endsWith("Controller")) {
                            messager.printMessage(
                                    Diagnostic.Kind.ERROR,
                                    "Class using @WebController must have suffix Controller",
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

