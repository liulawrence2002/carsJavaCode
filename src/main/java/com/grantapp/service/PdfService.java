package com.grantapp.service;

import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class PdfService {
    public void concatenatePDFs(List<File> files, String outputPath) throws IOException {
        PDFMergerUtility merger = new PDFMergerUtility();
        for (File file : files) {
            merger.addSource(file);
        }
        merger.setDestinationFileName(outputPath);
        merger.mergeDocuments(null);
    }
}