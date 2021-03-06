package com.github.chen0040.tensorflow.classifiers.demo;

import com.github.chen0040.tensorflow.classifiers.models.cifar10.Cifar10AudioClassifier;
import com.github.chen0040.tensorflow.classifiers.utils.FileUtils;
import com.github.chen0040.tensorflow.classifiers.utils.ResourceUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Cifar10AudioEncoderDemo {

    private static final Logger logger = LoggerFactory.getLogger(Cifar10AudioEncoderDemo.class);


    public static void main(String[] args) throws IOException {
        Cifar10AudioClassifier classifier = new Cifar10AudioClassifier();
        classifier.load_model();

        List<String> paths = FileUtils.getAudioFiles();

        Collections.shuffle(paths);

        for (String path : paths) {
            System.out.println("Encoding " + path + " ...");
            File f = new File(path);
            float[] encoded_audio = classifier.encode_audio(f);

            System.out.println("Encoded: " + Arrays.toString(encoded_audio));
        }
    }
}
