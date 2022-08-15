package com.linxi.dao;

import com.linxi.pojo.NoteType;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: linxi
 * Date: 2022/8/15
 * Time: 20:51
 * Description:
 */
public class NoteTypeDao {
    private static NoteTypeDao noteTypeDao = new NoteTypeDao();
    private Map<Integer, NoteType> noteTypeMap;

    private NoteTypeDao(){
        noteTypeMap= new HashMap<Integer, NoteType>();
        noteTypeMap.put(1,new NoteType(1,"java",1));
        noteTypeMap.put(2,new NoteType(2,"php",1));
        noteTypeMap.put(3,new NoteType(3,"scala",2));
    }
    public static NoteTypeDao getNoteTypeDao() {
        return noteTypeDao;
    }


    public Map<Integer, NoteType> getNoteTypesByUserId(Integer userId) {
        Map<Integer, NoteType> result = new HashMap<>();
        for(Map.Entry<Integer, NoteType> entry : noteTypeMap.entrySet()){
            if(entry.getValue().getUserId() == userId){
                result.put(entry.getKey(), entry.getValue());
            }
        }
//        System.out.println(result);
        return result;
    }

    public void addNoteType(NoteType noteType) {
        Integer index = noteTypeMap.size()+1;
        noteTypeMap.put(index, noteType);
    }

    public boolean updateNoteType(NoteType noteType) {
        for(Map.Entry<Integer, NoteType> entry : noteTypeMap.entrySet()){
            if(entry.getValue().getId() == noteType.getId()){
                noteTypeMap.replace(entry.getKey(), noteType);
                return true;
            }
        }
        return false;
    }

    public Map<Integer, NoteType> getNoteTypesById(Integer id) {
        Map<Integer, NoteType> result = new HashMap<>();
        for(Map.Entry<Integer, NoteType> entry : noteTypeMap.entrySet()){
            if(entry.getValue().getId() == id){
                result.put(entry.getKey(), entry.getValue());
            }
        }
        return result;
    }

    public boolean deleteNoteTypeById(Integer noteTypeId) {
        for(Map.Entry<Integer, NoteType> entry : noteTypeMap.entrySet()){
            if(entry.getValue().getId() == noteTypeId){
                noteTypeMap.remove(entry.getKey());
                return true;
            }
        }
        return false;
    }
}
