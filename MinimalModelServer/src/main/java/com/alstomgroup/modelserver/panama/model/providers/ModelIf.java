/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alstomgroup.modelserver.panama.model.providers;

import java.util.Map;


/**
 *
 * @author eduardo
 */
interface ModelIf {
    
    public Object predict(Map v);
    public Object predictProba(Map v);
}
