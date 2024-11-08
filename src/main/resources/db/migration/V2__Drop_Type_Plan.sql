
ALTER TABLE user_payment_plan DROP COLUMN payment_plan;
ALTER TABLE claims DROP COLUMN status;


DROP TYPE IF EXISTS public.plan CASCADE;
DROP TYPE IF EXISTS public.status CASCADE;


ALTER TABLE claims
ADD status VARCHAR(20) CHECK (status IN('approved', 'rejected', 'pending'));

ALTER TABLE user_payment_plan
ADD payment_plan VARCHAR(20) CHECK (payment_plan IN('monthly', 'annually'));