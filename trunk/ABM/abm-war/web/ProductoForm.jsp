<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : ProductoForm
    Created on : Aug 26, 2009, 11:37:52 AM
    Author     : markos
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head id="head1">
                    <webuijsf:link id="link1" url="/resources/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <webuijsf:form id="form1" virtualFormsConfig="insert | gridPanel1:txtPrecio gridPanel1:dropDownProveedor gridPanel1:txtCantidad gridPanel1:txtDescripcion gridPanel1:txtNombre | gridPanel2:btnAceptar gridPanel2:btnUpdate , cancelar | | gridPanel2:btnCancelar">
                        <h:panelGrid columns="2" id="gridPanel1"
                                style="position: absolute; left: 264px; top: 72px">c
                            <webuijsf:label id="label1" text="Nombre : "/>
                            <webuijsf:textField binding="#{ProductoForm.txtNombre}" id="txtNombre"/>
                            <webuijsf:label id="label2" text="Descripcion  : "/>
                            <webuijsf:textField binding="#{ProductoForm.txtDescripcion}" id="txtDescripcion"/>
                            <webuijsf:label id="label3" text="Cantidad  : "/>
                            <webuijsf:textField binding="#{ProductoForm.txtCantidad}" id="txtCantidad"/>
                            <webuijsf:label id="label4" text="Proveedor : "/>
                            <webuijsf:dropDown binding="#{ProductoForm.dropDownProveedor}" id="dropDownProveedor" items="#{ProductoForm.listaProveedoresOption}" valueChangeListenerExpression="#{ProductoForm.dropDownProveedor_processValueChange}"/>
                            <webuijsf:label id="label5" text="Precio : "/>
                            <webuijsf:textField binding="#{ProductoForm.txtPrecio}" id="txtPrecio"/>
                        </h:panelGrid>
                        <h:panelGrid columns="3" id="gridPanel2" style="left: 264px; top: 216px; position: absolute" width="168">
                            <webuijsf:button actionExpression="#{ProductoForm.btnAceptar_action}" binding="#{ProductoForm.btnAceptar}" id="btnAceptar" text="Aceptar"/>
                            <webuijsf:button actionExpression="#{ProductoForm.btnUpdate_action}" binding="#{ProductoForm.btnUpdate}" id="btnUpdate" text="Actualizar"/>
                            <webuijsf:button actionExpression="#{ProductoForm.btnCancelar_action}" binding="#{ProductoForm.btnCancelar}" id="btnCancelar" text="Cancelar"/>
                        </h:panelGrid>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
