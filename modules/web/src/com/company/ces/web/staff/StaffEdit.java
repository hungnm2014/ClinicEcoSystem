/*
 * Copyright (c) 2016 ces
 */
package com.company.ces.web.staff;

import com.haulmont.cuba.core.app.FileStorageService;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.global.FileStorageException;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.Embedded;
import com.haulmont.cuba.gui.components.FileUploadField;
import com.haulmont.cuba.gui.data.DataSupplier;
import com.haulmont.cuba.gui.data.Datasource;
import com.haulmont.cuba.gui.export.ExportDisplay;
import com.haulmont.cuba.gui.export.ExportFormat;
import com.haulmont.cuba.gui.upload.FileUploadingAPI;
import com.company.ces.entity.category.Staff;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author HenryKhanhHoang
 */
public class StaffEdit extends AbstractEditor<Staff> {
	  private Logger log = LoggerFactory.getLogger(getClass());

	    @Inject
	    private DataSupplier dataSupplier;
	    @Inject
	    private FileStorageService fileStorageService;
	    @Inject
	    private FileUploadingAPI fileUploadingAPI;
	    @Inject
	    private ExportDisplay exportDisplay;

	    @Inject
	    private Embedded embeddedImage;
	    @Inject
	    private FileUploadField uploadField;
	    @Inject
	    private Button downloadImageBtn;
	    @Inject
	    private Button clearImageBtn;
	    @Inject
	    private Datasource<Staff> staffDs;

	    private static final int IMG_HEIGHT = 220;
	    private static final int IMG_WIDTH = 250;

	    @Override
	    public void init(Map<String, Object> params) {
	        uploadField.addFileUploadSucceedListener(event -> {
	            FileDescriptor fd = uploadField.getFileDescriptor();
	            try {
	                fileUploadingAPI.putFileIntoStorage(uploadField.getFileId(), fd);
	            } catch (FileStorageException e) {
	                throw new RuntimeException("Error saving file to FileStorage", e);
	            }
	            getItem().setImageFileId(dataSupplier.commit(fd));
	            displayImage();
	        });

	        uploadField.addFileUploadErrorListener(event ->
	                showNotification("File upload error", NotificationType.HUMANIZED));

	        staffDs.addItemPropertyChangeListener(event -> {
	            if ("imageFile".equals(event.getProperty()))
	                updateImageButtons(event.getValue() != null);
	        });
	    }

	    @Override
	    protected void postInit() {
	        displayImage();
	        updateImageButtons(getItem().getImageFileId() != null);
	    }

	    public void onDownloadImageBtnClick() {
	        if (getItem().getImageFileId() != null)
	            exportDisplay.show(getItem().getImageFileId(), ExportFormat.OCTET_STREAM);
	    }

	    public void onClearImageBtnClick() {
	        getItem().setImageFileId(null);
	        displayImage();
	    }

	    private void updateImageButtons(boolean enable) {
	        downloadImageBtn.setEnabled(enable);
	        clearImageBtn.setEnabled(enable);
	    }

	    private void displayImage() {
	        byte[] bytes = null;
	        if (getItem().getImageFileId() != null) {
	            try {
	                bytes = fileStorageService.loadFile(getItem().getImageFileId());
	            } catch (FileStorageException e) {
	                log.error("Unable to load image file", e);
	                showNotification("Unable to load image file", NotificationType.HUMANIZED);
	            }
	        }
	        if (bytes != null) {
	            embeddedImage.setSource(getItem().getImageFileId().getName(), new ByteArrayInputStream(bytes));
	            embeddedImage.setType(Embedded.Type.IMAGE);
	            BufferedImage image;
	            try {
	                image = ImageIO.read(new ByteArrayInputStream(bytes));
	                int width = image.getWidth();
	                int height = image.getHeight();

	                if (((double) height / (double) width) > ((double) IMG_HEIGHT / (double) IMG_WIDTH)) {
	                    embeddedImage.setHeight(String.valueOf(IMG_HEIGHT));
	                    embeddedImage.setWidth(String.valueOf(width * IMG_HEIGHT / height));
	                } else {
	                    embeddedImage.setWidth(String.valueOf(IMG_WIDTH));
	                    embeddedImage.setHeight(String.valueOf(height * IMG_WIDTH / width));
	                }
	            } catch (IOException e) {
	                log.error("Unable to resize image", e);
	            }
	            // refresh image
	            embeddedImage.setVisible(false);
	            embeddedImage.setVisible(true);
	        } else {
	            embeddedImage.setVisible(false);
	        }
	    }
}