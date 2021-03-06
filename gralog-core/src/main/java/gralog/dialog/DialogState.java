package gralog.dialog;

public enum DialogState { ASK_WHAT_TO_SELECT, ASK_WHAT_TO_DESELECT, WAIT_FOR_WHAT_TO_SELECT, WAIT_FOR_WHAT_TO_DESELECT,
    ASK_WHAT_TO_FILTER, WAIT_FOR_WHAT_TO_FILTER, FILTER_ALL_ASK_FILTER_CONDITION,
      FILTER_ALL_VERTICES_ASK_FILTER_CONDITION, FILTER_ALL_EDGES_ASK_FILTER_CONDITION,
    ASK_FILTER_ALL_WHAT, FILTER, SELECT, DESELECT, SELECT_ALL, DESELECT_ALL, FILTER_ALL,FILTER_WHAT,
    FILTER_WHAT_WHERE, FILTER_WHAT_SUCH, FILTER_WHAT_WHERE_NO, FILTER_WHAT_WHERE_PARAM, FILTER_WHAT_WHERE_INTPARAM,
    FILTER_WHAT_WHERE_FLOATPARAM, FILTER_WHAT_WHERE_COLOR, FILTER_WHAT_WHERE_SHAPE, FILTER_WHAT_WHERE_EDGETYPE,
    FILTER_WHAT_WHERE_FILL,
    FILTER_WHAT_WHERE_STROKE, FILTER_WHAT_WHERE_EDGE, FILTER_WHAT_WHERE_HAS, FILTER_WHAT_WHERE_HASNT, FILTER_WHAT_WHERE_COND,
    FILTER_WHAT_WHERE_COND_TO, FILTER_SELECTED, FILTER_WHAT_WHERE_LABEL, FILTER_WHAT_WHERE_LABEL_CONTAINS,
    SORT, SORT_WHAT, SORT_WHAT_ID,SORT_WHAT_LABEL,
    TWOLISTSOP, TWOLISTSOP_WHAT, TWOLISTSOP_WHAT_WHAT,
    DELETE,
    COMPLEMENT, COMPLEMENT_WHAT,
    CONNECT, CONNECT_WHAT, CONNECT_WHAT_WHAT,
    PRINT,
    FIND, FIND_VERTEX, FIND_EDGE,
    LAYOUT,
    DONE
}
