/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.util.List;

/**
 *
 * @author Hans
 */
 
/**
 *

 * @param <Pojo>
 */
 
 
public interface Operaciones<Pojo> {
    public int create(Pojo p);
    public int delete(int id);
    public int edit(Pojo p);
    public List<Pojo> readAll();
    public Pojo read(int id);
}
