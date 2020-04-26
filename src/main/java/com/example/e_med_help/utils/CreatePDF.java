package com.example.e_med_help.utils;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class CreatePDF {

    private String name, surname, text;

    public CreatePDF() {
    }

    public MultipartFile createMedPDF(String name, String surname, String text) {

        MultipartFile multipartFile = null;
        try {
            PDDocument pDDocument = PDDocument.load(new File("src/pdfs/med-history-form.pdf"));
            PDAcroForm pDAcroForm = pDDocument.getDocumentCatalog().getAcroForm();
            pDAcroForm.getField("name").setValue(name);
            pDAcroForm.getField("surname").setValue(surname);
            pDAcroForm.getField("text").setValue(text);
            pDDocument.save("src/pdfs/med-history-form-output.pdf");
            pDDocument.close();
            System.out.println("pdf was created");
            File cretedFile = new File("src/pdfs/med-history-form-output.pdf");
            multipartFile = new MockMultipartFile(cretedFile.getName(), new FileInputStream(cretedFile));

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("multipart Created");
        return multipartFile;
    }


}
