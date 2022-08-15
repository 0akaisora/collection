package com.linxi.dao;

import org.junit.Test;

import static org.junit.Assert.*;

public class NoteTypeDaoTest {

    private NoteTypeDao noteTypeDao = NoteTypeDao.getNoteTypeDao();
    @Test
    public void getNoteTypesByUserId() {
        noteTypeDao.getNoteTypesByUserId(1);
    }
}