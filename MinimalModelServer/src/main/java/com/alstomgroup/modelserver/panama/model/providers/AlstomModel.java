/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alstomgroup.modelserver.panama.model.providers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;
import org.dmg.pmml.FieldName;
import org.dmg.pmml.PMML;
import org.jpmml.evaluator.ModelEvaluator;
import org.jpmml.evaluator.ModelEvaluatorFactory;
import org.jpmml.evaluator.ProbabilityDistribution;
import org.jpmml.model.PMMLUtil;
import org.xml.sax.SAXException;

import org.pmml4s.model.Model;

/**
 *
 * @author eduardo
 */
public class AlstomModel implements ModelIf{

    private Model model = null;
    //private ModelEvaluator<?> modelEvaluator;

    public AlstomModel(String modelname) {
        
        model = Model.fromFile(modelname);
    }

    @Override
    public Map predictProba(Map v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map predict(Map v) {
        
        Map result = model.predict(v);
        
        return result;
    }
    
}
