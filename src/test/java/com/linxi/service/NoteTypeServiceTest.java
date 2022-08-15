package com.linxi.service;

import com.linxi.pojo.NoteType;
import org.junit.Test;

import static org.junit.Assert.*;

public class NoteTypeServiceTest {
    private NoteTypeService noteTypeService = NoteTypeService.getNoteTypeService();

    @Test
    public void addNoteType() {
        noteTypeService.listNoteType(2);
        noteTypeService.addNoteType(new NoteType(4,"scala1",2));
        noteTypeService.listNoteType(2);
    }

    @Test
    public void updateNoteType() {
        noteTypeService.listNoteType(2);
        noteTypeService.addNoteType(new NoteType(4,"scala1",2));
        noteTypeService.listNoteType(2);
        noteTypeService.updateNoteType(new NoteType(4,"scala2",2));
        noteTypeService.listNoteType(2);
    }

    @Test
    public void delNoteType() {
        noteTypeService.listNoteType(2);
        noteTypeService.addNoteType(new NoteType(4,"scala1",2));
        noteTypeService.listNoteType(2);
        noteTypeService.updateNoteType(new NoteType(4,"scala2",2));
        noteTypeService.listNoteType(2);
        noteTypeService.delNoteType(3);
        noteTypeService.listNoteType(2);
    }
}