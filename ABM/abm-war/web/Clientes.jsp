<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : Clientes
    Created on : Aug 26, 2009, 11:30:46 PM
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
                                title="CLIENTES" width="450">
                                <f:facet name="actionsTop">
                                    <webuijsf:panelGroup id="groupPanel1">
                                        <webuijsf:label id="lblFiltro1" text="Busqueda"/>
                                        <webuijsf:textField binding="#{Clientes.txtFiltro}" id="txtFiltro"/>
                                        <webuijsf:dropDown binding="#{Clientes.dropDownFiltro}" id="dropDownFiltro" items="#{Clientes.opcionFiltro}"/>
                                        <webuijsf:button actionExpression="#{Clientes.btnBuscar_action}" alt="Filtro" id="btnBuscar" text="Buscar" toolTip="Filtro"/>
                                        <webuijsf:button actionExpression="#{Clientes.botonLimpiar_action}" id="botonLimpiar" text="Limpiar"/>
                                    </webuijsf:panelGroup>
                                </f:facet>
                                <webuijsf:tableRowGroup id="tableRowGroup" rows="5" selected="#{Clientes.selectedState}" sourceData="#{Clientes.listaClientes}" sourceVar="currentRow">
                                    <webuijsf:tableColumn headerText="Código" id="tableColumn1" sort="codigo" binding="#{Clientes.tableRowGroup}">
                                        <webuijsf:staticText id="staticText1" text="#{currentRow.value['idcliente']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn headerText="Nombre" id="tableColumn2" sort="nombre">
                                        <webuijsf:staticText id="staticText2" text="#{currentRow.value['nombre']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn headerText="Apellido" id="tableColumn3" sort="apellido">
                                        <webuijsf:staticText id="staticText3" text="#{currentRow.value['apellido']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn id="tableColumn5" sort="column3">
                                        <webuijsf:button actionExpression="#{Clientes.botonModificar_action}" id="botonModificar1" text="Modificar"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn id="tableColumn6" sort="column4">
                                        <webuijsf:button actionExpression="#{Clientes.botonEliminar_action}" id="botonEliminar1" text="Eliminar"/>
                                    </webuijsf:tableColumn>
                                </webuijsf:tableRowGroup>
                            </webuijsf:table>
                            <webuijsf:button actionExpression="#{Clientes.botonInsertar1_action}" id="botonInsertar1" text="Insertar"/>
                        </h:panelGrid>
                        <webuijsf:messageGroup id="messageGroup1" style="left: 0px; top: 0px; position: absolute" title="SCS"/>
                        <h:panelGrid binding="#{Clientes.gridPanelDown}" id="gridPanelDown" style="left: 24px; top: 240px; position: absolute">
                            <h:panelGrid binding="#{Clientes.gridPanelForm}" columns="2" id="gridPanelForm">
                                <webuijsf:label id="label1" text="Nombre : "/>
                                <webuijsf:textField binding="#{Clientes.txtNombre}" id="txtNombre"/>
                                <webuijsf:label id="label2" text="Apellido  : "/>
                                <webuijsf:textField binding="#{Clientes.txtApellido}" id="txtApellido"/>
                                <webuijsf:label id="label3" text="CI : "/>
                                <webuijsf:textField binding="#{Clientes.txtCi}" id="txtCi"/>
                                <webuijsf:label id="label4" text="Direccion : "/>
                                <webuijsf:textField binding="#{Clientes.txtDireccion}" id="txtDireccion"/>
                                <webuijsf:label id="label5" text="RUC : "/>
                                <webuijsf:textField binding="#{Clientes.txtRuc}" id="txtRuc"/>
                            </h:panelGrid>
                            <h:panelGrid binding="#{Clientes.gridPanelBotones}" columns="3" id="gridPanelBotones" width="168">
                                <webuijsf:button actionExpression="#{Clientes.btnAceptar_action}" binding="#{Clientes.btnAceptar}" id="btnAceptar" text="Aceptar"/>
                                <webuijsf:button actionExpression="#{Clientes.btnUpdate_action}" binding="#{Clientes.btnUpdate}" id="btnUpdate" text="Actualizar"/>
                                <webuijsf:button actionExpression="#{Clientes.btnCancelar_action}" binding="#{Clientes.btnCancelar1}" id="btnCancelar1" text="Cancelar"/>
                            </h:panelGrid>
                        </h:panelGrid>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
