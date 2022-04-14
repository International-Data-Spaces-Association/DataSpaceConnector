ALTER TABLE public.agreement
    RENAME COLUMN value to agreement_value;

ALTER TABLE public.data
    RENAME COLUMN value to localdata_value;

ALTER TABLE public.authentication
    RENAME COLUMN key to api_key;

ALTER TABLE public.authentication
    RENAME COLUMN value to api_value;

ALTER TABLE public.route
    RENAME COLUMN end to route_end;

ALTER TABLE public.contractrule
    RENAME COLUMN value to contractrule_value;

UPDATE public.configuration SET active = false WHERE active != true;
