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
                    <webuijsf:form id="form1">
                        <webuijsf:messageGroup id="messageGroup" title="SCS"/>
                        <h:panelGrid binding="#{Productos.gridPanelContent}" id="gridPanelContent" styleClass="panelContent">
                            <webuijsf:table augmentTitle="false" id="table1" paginateButton="true" paginationControls="true" style="width: 450px"
                                title="PRODUCTOS" width="450">
                                <f:facet name="actionsTop">
                                    <webuijsf:panelGroup id="groupPanel1">
                                        <webuijsf:label id="lblFiltro" text="Busqueda"/>
                                        <webuijsf:textField binding="#{Productos.txtFiltro}" id="txtFiltro"/>
                                        <webuijsf:dropDown binding="#{Productos.dropDownFiltro}" id="dropDownFiltro" items="#{Productos.optionFiltro}"/>
                                        <webuijsf:button actionExpression="#{Productos.btnBuscar_action}" alt="Filtro" id="btnBuscar" text="Buscar" toolTip="Filtro"/>
                                        <webuijsf:button actionExpression="#{Productos.botonLimpiar_action}" id="botonLimpiar" text="Limpiar"/>
                                    </webuijsf:panelGroup>
                                </f:facet>
                                <webuijsf:tableRowGroup binding="#{Productos.tableRowGroup}" id="tableRowGroup1" rows="5"
                                    sourceData="#{Productos.listaProductos}" sourceVar="currentRow">
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
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
