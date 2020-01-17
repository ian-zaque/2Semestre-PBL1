package br.uefs.ecomp.organizer;

import br.uefs.ecomp.organizer.model.BookTest;
import br.uefs.ecomp.organizer.model.ChapterTest;
import br.uefs.ecomp.organizer.model.AuthorTest;
import br.uefs.ecomp.organizer.model.SystemTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import br.uefs.ecomp.organizer.util.ListTest;
import br.uefs.ecomp.organizer.util.StackTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	StackTest.class,
        ListTest.class,
        ChapterTest.class,
        BookTest.class,
        AuthorTest.class,
        SystemTest.class
})
public class AllTests { }
