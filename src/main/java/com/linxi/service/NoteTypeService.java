package com.linxi.service;


import com.linxi.dao.NoteTypeDao;
import com.linxi.pojo.NoteType;
import com.linxi.service.check.CheckParas;

import java.util.HashMap;
import java.util.Map;

/**
 * 云记类别管理
 *    云记类别遍历
 *    云记类别添加
 *    云记类别更新
 *    云记类别删除
 */
public class NoteTypeService {

    private Map<Integer,NoteType> noteTypeMap;
    private NoteTypeDao noteTypeDao = NoteTypeDao.getNoteTypeDao();
    private static NoteTypeService noteTypeService = new NoteTypeService();

    private NoteTypeService() {
        noteTypeMap= new HashMap<Integer, NoteType>();
        noteTypeMap.put(1,new NoteType(1,"java",1));
        noteTypeMap.put(2,new NoteType(2,"php",1));
        noteTypeMap.put(3,new NoteType(3,"scala",2));
    }

    public static NoteTypeService getNoteTypeService() {
        return noteTypeService;
    }

    public void addNoteType(NoteType noteType){
        /**
         * 1.参数校验
         *    类别名 不能为空 用户id 必须存在(UserService->List<User> 必须存在对应用户记录)
         * 2.当前用户下类别名称不可重复
         * 3.执行添加
         */
        CheckParas.isBlank(noteType.getId(), "类别编号");
        CheckParas.isBlank(noteType.getTypeName(), "类别名");
        CheckParas.isBlank(noteType.getUserId(), "用户编号");
        CheckParas.isNullUserId(noteType.getUserId());
        CheckParas.isRepeatNoteTypeName(noteType);
        noteTypeDao.addNoteType(noteType);


    }

    /**
     * 根据登录用户查询云记类别
     * @param userId
     */
    public void listNoteType(Integer userId){
        System.out.println("-------------------------------");
        Map<Integer, NoteType> reuslt = noteTypeDao.getNoteTypesByUserId(userId);
        for(Map.Entry<Integer, NoteType> Entry : reuslt.entrySet()){
            System.out.println(Entry.getKey() + ":" + Entry.getValue());
        }
        System.out.println("-------------------------------");
    }


    public void updateNoteType(NoteType noteType){
        /**
         * 1.参数校验
         *    类别名 不能为空
         *    用户id 必须存在(UserService->List<User> 必须存在对应用户记录)
         *    云记类别id 必须存在
         * 2.当前用户下类别名称不可重复
         * 3.执行更新
         */
        CheckParas.isBlank(noteType.getTypeName(), "类别名");
        CheckParas.isNullUserId(noteType.getUserId());
        CheckParas.isNullNoteTypeId(noteType.getId());
        CheckParas.isRepeatNoteTypeName(noteType);
        noteTypeDao.updateNoteType(noteType);
    }

    public void delNoteType(Integer noteTypeId){
        /**
         * 1.参数校验
         *    云记类别id 必须存在
         * 2.如果类别下存在云记记录 不允许删除
         * 3.执行删除
         */
        CheckParas.isNullNoteTypeId(noteTypeId);
        noteTypeDao.deleteNoteTypeById(noteTypeId);
    }


}
