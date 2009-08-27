<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : Ventas
    Created on : Aug 26, 2009, 11:31:03 PM
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
                    <webuijsf:form id="form1">
                        <h:panelGrid id="gridPanelContent1" style="left: 0px; top: 48px; position: absolute" styleClass="panelContent">
                            <webuijsf:table augmentTitle="false" id="table1" paginateButton="true" paginationControls="true" style="width: 450px"
                                title="PRODUCTOS" width="450">
                                <f:facet name="actionsTop">
                                    <webuijsf:panelGroup id="groupPanel1">
                                        <webuijsf:label id="lblFiltro1" text="Busqueda"/>
                                        <webuijsf:textField id="txtFiltro1"/>
                                        <webuijsf:dropDown id="dropDownFiltro1" items="#{Productos.opcionFiltro}"/>
                                        <webuijsf:button actionExpression="#{Ventas.btnBuscar_action}" alt="Filtro" id="btnBuscar1" text="Buscar" toolTip="Filtro"/>
                                        <webuijsf:button actionExpression="#{Ventas.botonLimpiar_action}" id="botonLimpiar1" text="Limpiar"/>
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
                                        <webuijsf:button actionExpression="#{Ventas.botonModificar_action}" id="botonModificar1" text="Modificar"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn id="tableColumn6" sort="column4">
                                        <webuijsf:button actionExpression="#{Ventas.botonEliminar_action}" id="botonEliminar1" text="Eliminar"/>
                                    </webuijsf:tableColumn>
                                </webuijsf:tableRowGroup>
                            </webuijsf:table>
                            <webuijsf:button actionExpression="#{Ventas.botonInsertar1_action}" id="botonInsertar1" text="Insertar"/>
                        </h:panelGrid>
                        <webuijsf:messageGroup id="messageGroup1" style="left: 0px; top: 0px; position: absolute" title="SCS"/>
                        <h:panelGrid id="gridPanelDown1" style="left: 0px; top: 192px; position: absolute">
                            <h:panelGrid columns="2" id="gridPanelForm1">
                                <webuijsf:label id="label3" text="Cantidad  : "/>
                                <webuijsf:textField columns="10" id="txtCantidad"/>
                                <webuijsf:label id="label4" text="Proveedor : "/>
                                <webuijsf:dropDown id="dropDownProveedor" items="#{Productos.listaProveedoresOption}"/>
                                <webuijsf:label id="label5" text="Cliente : "/>
                                <webuijsf:dropDown id="dropDownCliente" items="#{Productos.listaProveedoresOption}"/>
                            </h:panelGrid>
                            <h:panelGrid columns="3" id="gridPanelBotones1" width="168">
                                <webuijsf:button actionExpression="#{Ventas.btnAceptar_action}" id="btnAceptar1" text="Aceptar"/>
                                <webuijsf:button actionExpression="#{Ventas.btnUpdate_action}" id="btnUpdate1" text="Actualizar"/>
                                <webuijsf:button actionExpression="#{Ventas.btnCancelar_action}" id="btnCancelar1" text="Cancelar"/>
                            </h:panelGrid>
                        </h:panelGrid>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
