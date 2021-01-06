package com.example.commands;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotesCommand {
    private Long notesId;
    private String recipeNotes;
    private Long recipeId;
}
