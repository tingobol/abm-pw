<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : Productos
    Created on : 26-ago-2009, 6:13:31
    Author     : liz
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
                    <webuijsf:form id="form1" virtualFormsConfig="edit | gridPanelDown:gridPanelForm:txtNombre1 gridPanelDown:gridPanelForm:txtDescripcion1 gridPanelDown:gridPanelForm:txtCantidad1 gridPanelDown:gridPanelForm:dropDownProveedor1 gridPanelDown:gridPanelForm:txtPrecio1 | gridPanelDown:gridPanelBotones:btnAceptar gridPanelDown:gridPanelBotones:btnUpdate , cancel | | gridPanelDown:gridPanelBotones:btnCancelar , search | gridPanelContent:table1:groupPanel1:txtFiltro gridPanelContent:table1:groupPanel1:dropDownFiltro | gridPanelContent:table1:groupPanel1:btnBuscar">
                        <webuijsf:messageGroup id="messageGroup" title="SCS"/>
                        <h:panelGrid binding="#{Productos.gridPanelContent}" id="gridPanelContent" styleClass="panelContent">
                            <webuijsf:table augmentTitle="false" id="table1" paginateButton="true" paginationControls="true" style="width: 450px"
                                            title="PRODUCTOS" width="450">
                                <f:facet name="actionsTop">
                                    <webuijsf:panelGroup id="groupPanel1">
                                        <webuijsf:label id="lblFiltro" text="Busqueda"/>
                                        <webuijsf:textField binding="#{Productos.txtFiltro}" id="txtFiltro"/>
                                        <webuijsf:dropDown binding="#{Productos.dropDownFiltro}" id="dropDownFiltro" items="#{Productos.opcionFiltro}"/>
                                        <webuijsf:button actionExpression="#{Productos.btnBuscar_action}" alt="Filtro" id="btnBuscar" text="Buscar" toolTip="Filtro"/>
                                        <webuijsf:button actionExpression="#{Productos.botonLimpiar_action}" id="botonLimpiar" text="Limpiar"/>
                                    </webuijsf:panelGroup>
                                </f:facet>
                                <webuijsf:tableRowGroup binding="#{Productos.tableRowGroup}" id="tableRowGroup" rows="5"
                                                        selected="#{Productos.selectedState}" sourceData="#{Productos.listaProductos}" sourceVar="currentRow">
                                    <webuijsf:tableColumn headerText="Código" id="tableColumn0" sort="codigo">
                                        <webuijsf:staticText id="staticText0" text="#{currentRow.value['codigo']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn headerText="Nombre" id="tableColumn1" sort="nombre">
                                        <webuijsf:staticText id="staticText1" text="#{currentRow.value['nombre']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn headerText="Descripción" id="tableColumn2" sort="descripcion">
                                        <webuijsf:staticText id="staticText2" text="#{currentRow.value['descripcion']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn headerText="Precio" id="tableColumn10" sort="precio" width="54">
                                        <webuijsf:staticText id="staticText10" text="#{currentRow.value['precio']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn id="tableColumn3" sort="column3">
                                        <webuijsf:button actionExpression="#{Productos.botonModificar_action}" id="botonModificar" text="Modificar"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn id="tableColumn4" sort="column4">
                                        <webuijsf:button actionExpression="#{Productos.botonEliminar_action}" id="botonEliminar" text="Eliminar"/>
                                    </webuijsf:tableColumn>
                                </webuijsf:tableRowGroup>
                            </webuijsf:table>
                            <webuijsf:button actionExpression="#{Productos.botonInsertar1_action}" binding="#{Productos.botonInsertar1}" id="botonInsertar1" text="Insertar"/>
                        </h:panelGrid>
                        <h:panelGrid binding="#{Productos.gridPanelDown}" id="gridPanelDown" style="left: 48px; top: 192px; position: absolute">
                            <h:panelGrid binding="#{Productos.gridPanelForm}" columns="2" id="gridPanelForm">
                                <webuijsf:label id="label1" text="Nombre : "/>
                                <webuijsf:textField id="txtNombre1"/>
                                <webuijsf:label id="label2" text="Descripcion  : "/>
                                <webuijsf:textField id="txtDescripcion1"/>
                                <webuijsf:label id="label3" text="Cantidad  : "/>
                                <webuijsf:textField id="txtCantidad1"/>
                                <webuijsf:label id="label4" text="Proveedor : "/>
                                <webuijsf:dropDown id="dropDownProveedor1" items="#{Productos.listaProveedoresOption}"/>
                                <webuijsf:label id="label5" text="Precio : "/>
                                <webuijsf:textField id="txtPrecio1"/>
                            </h:panelGrid>
                            <h:panelGrid binding="#{Productos.gridPanelBotones}" columns="3" id="gridPanelBotones" width="168">
                                <webuijsf:button actionExpression="#{Productos.btnAceptar_action}" binding="#{Productos.btnAceptar}" id="btnAceptar" text="Aceptar"/>
                                <webuijsf:button actionExpression="#{Productos.btnUpdate_action}" binding="#{Productos.btnUpdate}" id="btnUpdate" text="Actualizar"/>
                                <webuijsf:button actionExpression="#{Productos.btnCancelar_action}" id="btnCancelar" text="Cancelar"/>
                            </h:panelGrid>
                        </h:panelGrid>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
