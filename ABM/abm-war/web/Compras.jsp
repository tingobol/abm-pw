<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : Compras
    Created on : Aug 26, 2009, 11:30:55 PM
    Author     : markos
-->
<jsp:root version="2.1" xmlns:df="http://java.sun.com/jsf/dynamicfaces" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head id="head1">
                    <webuijsf:link id="link1" url="/resources/stylesheet.css"/>
                    <df:ajaxTransaction id="ajaxTransaction1" inputs="page1:html1:body1:form1:gridPanelDown1:gridPanelForm1:dropDownProveedor" render="page1:html1:body1:form1:gridPanelDown1:gridPanelForm1:dropDownProducto"/>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <webuijsf:form id="form1">
                        <h:panelGrid id="gridPanelContent1" style="left: 0px; top: 48px; position: absolute" styleClass="panelContent">
                            <webuijsf:table augmentTitle="false" id="table1" paginateButton="true" paginationControls="true" style="width: 450px"
                                title="PRODUCTOS" width="450">
                                <f:facet name="actionsTop">
                                    <webuijsf:panelGroup id="groupPanel1">
                                        <webuijsf:label id="lblFiltro1" text="Busqueda"/>
                                        <webuijsf:textField id="txtFiltro1"/>
                                        <webuijsf:dropDown id="dropDownFiltro1" items="#{Productos.opcionFiltro}"/>
                                        <webuijsf:button actionExpression="#{Compras.btnBuscar_action}" alt="Filtro" id="btnBuscar1" text="Buscar" toolTip="Filtro"/>
                                        <webuijsf:button actionExpression="#{Compras.botonLimpiar_action}" id="botonLimpiar1" text="Limpiar"/>
                                    </webuijsf:panelGroup>
                                </f:facet>
                                <webuijsf:tableRowGroup id="tableRowGroup1" rows="5" selected="#{Productos.selectedState}"
                                    sourceData="#{Productos.listaProductos}" sourceVar="currentRow">
                                    <webuijsf:tableColumn headerText="Código" id="tableColumn1" sort="codigo">
                                        <webuijsf:staticText id="staticText1" text="#{currentRow.value['codigo']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn headerText="Nombre" id="tableColumn2" sort="nombre">
                                        <webuijsf:staticText id="staticText2" text="#{currentRow.value['nombre']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn headerText="Descripción" id="tableColumn3" sort="descripcion">
                                        <webuijsf:staticText id="staticText3" text="#{currentRow.value['descripcion']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn headerText="Precio" id="tableColumn4" sort="precio" width="54">
                                        <webuijsf:staticText id="staticText4" text="#{currentRow.value['precio']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn id="tableColumn5" sort="column3">
                                        <webuijsf:button actionExpression="#{Compras.botonModificar_action}" id="botonModificar1" text="Modificar"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn id="tableColumn6" sort="column4">
                                        <webuijsf:button actionExpression="#{Compras.botonEliminar_action}" id="botonEliminar1" text="Eliminar"/>
                                    </webuijsf:tableColumn>
                                </webuijsf:tableRowGroup>
                            </webuijsf:table>
                            <webuijsf:button actionExpression="#{Compras.botonInsertar1_action}" id="botonInsertar1" text="Insertar"/>
                        </h:panelGrid>
                        <webuijsf:messageGroup id="messageGroup1" style="left: 0px; top: 0px; position: absolute" title="SCS"/>
                        <h:panelGrid id="gridPanelDown1" style="left: 0px; top: 216px; position: absolute">
                            <h:panelGrid columns="2" id="gridPanelForm1">
                                <webuijsf:label id="label1" text="Detalle : "/>
                                <webuijsf:textField binding="#{Compras.txtDetalle}" columns="50" id="txtDetalle"/>
                                <webuijsf:label id="label2" text="Nombre  : "/>
                                <webuijsf:textField binding="#{Compras.txtNombre}" id="txtNombre"/>
                                <webuijsf:label id="label4" text="Proveedor : "/>
                                <webuijsf:dropDown binding="#{Compras.dropDownProveedor}" id="dropDownProveedor" items="#{Productos.listaProveedoresOption}"/>
                                <webuijsf:label id="label5" text="Producto : "/>
                                <webuijsf:dropDown binding="#{Compras.dropDownProducto}" id="dropDownProducto" items="#{Productos.listaProveedoresOption}"/>
                                <webuijsf:label id="label3" text="Cantidad  : "/>
                                <webuijsf:textField binding="#{Compras.txtCantidad}" id="txtCantidad"/>
                            </h:panelGrid>
                            <h:panelGrid columns="3" id="gridPanelBotones1" width="168">
                                <webuijsf:button actionExpression="#{Compras.btnAceptar_action}" id="btnAceptar" text="Aceptar"/>
                                <webuijsf:button actionExpression="#{Compras.btnUpdate_action}" id="btnUpdate" text="Actualizar"/>
                                <webuijsf:button actionExpression="#{Compras.btnCancelar_action}" id="btnCancelar" text="Cancelar"/>
                            </h:panelGrid>
                        </h:panelGrid>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
